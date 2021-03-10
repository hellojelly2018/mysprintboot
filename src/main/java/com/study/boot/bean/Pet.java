package com.study.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Yangjiali
 * @create 2021-03-16:06 16:06
 */
//@Component
@ConfigurationProperties(prefix = "mypet")
public class Pet {
    private String name;
    private Double weight;

    public Pet() {
    }

    public Pet(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
