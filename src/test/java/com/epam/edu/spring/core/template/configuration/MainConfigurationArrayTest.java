package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:applicationArray.properties")
@ContextConfiguration(classes = MainConfiguration.class)
public class MainConfigurationArrayTest {

    @Autowired
    private MainConfiguration mainConfiguration;

    @Test
    public void testPropertyMainConfiguration() {
        Assert.assertEquals(mainConfiguration.implementation, "array");
    }

    @Test
    public void testInstanceOfMainConfiguration() {
        assertThat(mainConfiguration, instanceOf(MainConfiguration.class));
    }

    @Test
    public void testInstanceOfGetColor() throws Exception {
        assertThat(mainConfiguration.getColor(), instanceOf(Color.class));
    }
}