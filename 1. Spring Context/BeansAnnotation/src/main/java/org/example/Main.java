package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Accessing default bean of parrot class
        Parrot p = context.getBean(Parrot.class);

        // If we want to access other bean of same class.
        Parrot p2 = context.getBean("Joey", Parrot.class);

        int n = context.getBean(Integer.class);
        String s = context.getBean(String.class);

        System.out.println(p2.getName());
        System.out.println(n);
        System.out.println(s);

    }
}

@Configuration
class ProjectConfig {

    @Bean
    Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    @Primary        // Default bean [Optional]
    Parrot parrot2() {
        Parrot p = new Parrot();
        p.setName("Mika");
        return p;
    }

    @Bean("Joey")       // We can give a custom name to a bean like this. Default bean name is method name.
                        // Other ways to give bean name is:
                                    // @Bean(name = "Joey")
                                    // @Bean(value = "Joey")
    Parrot parrot3() {
        Parrot p = new Parrot();
        p.setName("Joey");
        return p;
    }

    @Bean
    Integer ten() {
        return 10;
    }

    @Bean
    String hello() {
        return "hello";
    }
}

class Parrot {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}