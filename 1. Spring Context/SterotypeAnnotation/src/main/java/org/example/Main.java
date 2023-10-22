package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p);
        System.out.println(p.getName());

    }
}

@Configuration
@ComponentScan(basePackages = "org.example")
class ProjectConfig {

}

@Component
class Parrot {
    String name;

    @PostConstruct          // Use when we want to call a method right after creating the object in
                            // the application context. [OPTIONAL]
    public void init() {
        this.name = "Ayush Sachan";
        System.out.println("Calling init method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}