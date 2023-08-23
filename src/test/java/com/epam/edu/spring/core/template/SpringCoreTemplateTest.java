package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.util.ClassUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {MainConfiguration.class})
@DisplayName("Spring beans tests")
class SpringCoreTemplateTest {

  @Autowired
  private final ApplicationContext context =
      new AnnotationConfigApplicationContext(MainConfiguration.class);

  @DisplayName("Test beans exists")
  @ParameterizedTest
  @MethodSource("getBeansWithClasses")
  void testCorrectBeansInstance(String beanName, String clazz) {
    assertTrue(isCorrectBean(context.getBean(beanName), clazz));
  }

  @Test
  @DisplayName("Test array list initial sequence value")
  void testInitialSequenceArrayList(@Value("${initial.sequence}") int propertyValue) {
    ArrayListItemRepository arrayListItemRepository =
        context.getBean("arrayListItemRepository", ArrayListItemRepository.class);
    assertEquals(propertyValue, arrayListItemRepository.getInitialSequence());
  }

  @Test
  @DisplayName("Test linked list initial sequence value")
  void testRandomInitialSequenceLinkedList() {
    LinkedListItemRepository linkedListItemRepository =
        context.getBean("linkedListItemRepository", LinkedListItemRepository.class);
    int initialSequence = linkedListItemRepository.getInitialSequence();
    assertTrue(initialSequence >= 0 && initialSequence < 100);
  }

  @Test
  @DisplayName("Test Color Bean")
  void testColorFactoryBean() {
    Color color = context.getBean("colorFactoryBean", Color.class);
    boolean colorCheck = false;
    colorCheck = Arrays.stream(Color.values()).anyMatch(Predicate.isEqual(color));
    assertTrue(colorCheck);
  }

  @Test
  @DisplayName("Test item repository type")
  void testItemRepositoryType(
      @Value("${item.repository.implementation=link}") String itemRepositoryProperty) {
    Object itemRepository = context.getBean("itemRepository");
    if ("link".equalsIgnoreCase(itemRepositoryProperty)) {
      assertTrue(isCorrectBean(itemRepository, "LinkedListItemRepository"));
    } else {
      assertTrue(isCorrectBean(itemRepository, "ArrayListItemRepository"));
    }
  }

  private boolean isCorrectBean(Object bean, String clazz) {
    return Objects.nonNull(bean) && ClassUtils.getUserClass(bean).getSimpleName().equals(clazz);
  }

  private static Stream<Arguments> getBeansWithClasses() {
    return Stream.of(
        Arguments.of("mainConfiguration", "MainConfiguration"),
        Arguments.of("initializerConfiguration", "InitializerConfiguration"),
        Arguments.of("repositoryConfiguration", "RepositoryConfiguration"),
        Arguments.of("arrayListItemRepository", "ArrayListItemRepository"),
        Arguments.of("linkedListItemRepository", "LinkedListItemRepository"),
        Arguments.of("simpleItemService", "SimpleItemService"),
        Arguments.of("simpleItemValidator", "SimpleItemValidator"));
  }
}
