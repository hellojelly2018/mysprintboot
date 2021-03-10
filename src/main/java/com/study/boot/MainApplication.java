package com.study.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.study.boot")
public class MainApplication {
    public static void main(String[] args) {
//        SpringApplication.run(MainApplication.class);
        SpringApplication app = new SpringApplication(MainApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        ConfigurableApplicationContext cat = app.run(args);

        String[] beanNames = cat.getBeanDefinitionNames();
        for(String name : beanNames) {
            System.out.println(name);
        }
        System.out.println(cat.containsBean("tomcatPet"));
    }
}
