package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfiguration.class)
public class RepositoryConfigurationTest {

    @Autowired
    private RepositoryConfiguration repositoryConfiguration;

    @Test
    public void testInstanceOfArraylistRepository() {
        assertThat(repositoryConfiguration.arrayListItemRepository(), instanceOf(ArrayListItemRepository.class));
    }

    @Test
    public void testInstanceOfLinkedListRepository() {
        assertThat(repositoryConfiguration.linkedListItemRepository(), instanceOf(LinkedListItemRepository.class));
    }
}