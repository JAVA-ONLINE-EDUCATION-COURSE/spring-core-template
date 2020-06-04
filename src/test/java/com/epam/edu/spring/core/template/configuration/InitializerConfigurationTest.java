package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.ColorFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;


import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InitializerConfiguration.class)
public class InitializerConfigurationTest {

    @Autowired
    private InitializerConfiguration configuration;

    @Test
    public void testInitializerInstanceOf() throws Exception {
        assertThat(configuration, instanceOf(InitializerConfiguration.class));
        assertThat(configuration.colorFactory(), instanceOf(ColorFactory.class));
        assertThat(configuration.getColor(), instanceOf(Color.class));
    }

}