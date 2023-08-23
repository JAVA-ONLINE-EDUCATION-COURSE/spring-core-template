package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.factory.ColorFactoryBean;
import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class InitializerConfiguration {

  @Bean
  @Lazy
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public Color colorBean(ColorFactoryBean colorFactoryBean) {
    return colorFactoryBean.getObject();
  }
}
