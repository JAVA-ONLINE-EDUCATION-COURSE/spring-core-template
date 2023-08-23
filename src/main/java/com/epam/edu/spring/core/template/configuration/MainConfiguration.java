package com.epam.edu.spring.core.template.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.epam.edu.spring.core.template"})
@Import({RepositoryConfiguration.class, InitializerConfiguration.class})
public class MainConfiguration {}
