package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.ColorFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringCoreTemplate.class)
public class SpringEducationSkeletonApplicationTests {


    @Test
    public void contextLoads() {
        assertTrue(true);
    }
    @Test
    public void colorFactoryTest(){
        ColorFactory colorFactory = new ColorFactory();
        colorFactory.initColors();
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("yellow");
        colors.add("black");
        colors.add("purple");
        assertTrue(colors.equals(colorFactory.getColors()));
    }
}
