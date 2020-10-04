package com.epam.edu.spring.core.template.configuration;

import org.springframework.context.annotation.Import;

@Import({RepositoryConfiguration.class, InitializerConfiguration.class})
public class MainConfiguration {


}
