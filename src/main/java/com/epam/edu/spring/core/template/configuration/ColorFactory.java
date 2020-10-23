package com.epam.edu.spring.core.template.configuration;

import com.epam.edu.spring.core.template.entity.Color;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Lazy
public class ColorFactory {

    @Scope("prototype")
    public Color getColor() {
        return Color.values()[new Random().nextInt(Color.values().length)];
    }

}
