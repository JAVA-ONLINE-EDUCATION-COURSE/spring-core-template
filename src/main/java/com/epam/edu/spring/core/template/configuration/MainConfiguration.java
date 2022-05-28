package com.epam.edu.spring.core.template.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({InitializerConfiguration.class, RepositoryConfiguration.class})
public class MainConfiguration {

}
