package com.epam.edu.spring.core.template.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ColorFactory {

    private ResourceBundle prop = ResourceBundle.getBundle("application");
    ArrayList<String> colors = new ArrayList<>();

    public void initColors() {

        String color;
        int colorNumber = 0;
        while (true) {
            try {
                color = prop.getString("colors.value[" + colorNumber + "]");
            } catch (MissingResourceException e) {
                break;
            }
            colors.add(color);
            colorNumber++;
        }

    }

    public List<String> getColors() {
        return colors;
    }
}
