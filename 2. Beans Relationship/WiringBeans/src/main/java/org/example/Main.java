package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person.getName());
        System.out.println(person.getParrot());
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
    Person person() {
        Person p = new Person();
        p.setName("Ayush");
        p.setParrot(parrot());
        return p;
    }


    // Another way to define relationship among beans by passing Parrot as a method argument. (3.1.2)
//    @Bean
//    Person person(Parrot parrot) {
//        Person p = new Person();
//        p.setName("Ayush");
//        p.setParrot(parrot);
//        return p;
//    }
}

class Parrot {
    String name;

    public String toString() {
        return "Parrot name: " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Person {
    String name;
    Parrot parrot;

    public String getName() {
        return name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    public void setName(String name) {
        this.name = name;
    }
}