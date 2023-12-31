package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person.getParrot());

    }
}

@Configuration
@ComponentScan(basePackages = "org.example")
class ProjectConfig { }

@Component
class Person {
    String name;

    // @Autowired        Not recommended (3.2.1), unable to make member variable 'final'
    Parrot parrot;

    @Autowired          // Recommended  (3.2.2)
    Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

//    @Autowired        Strictly not recommended (3.2.3), it’s more challenging to read, it doesn't allow you to make the field final, and it doesn’t help you in making the testing easier.
//    public void setParrot(Parrot parrot) {
//        this.parrot = parrot;
//    }

    public void setName(String name) {
        this.name = name;
    }
}

@Component
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
