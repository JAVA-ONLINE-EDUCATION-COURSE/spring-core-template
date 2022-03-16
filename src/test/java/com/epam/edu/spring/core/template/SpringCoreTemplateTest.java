package com.epam.edu.spring.core.template;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SpringCoreTemplate.class)
public class SpringCoreTemplateTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    @DisplayName("context loading")
    public void contextLoads() {
        assertThat(applicationContext).isNotNull();
    }

    }

