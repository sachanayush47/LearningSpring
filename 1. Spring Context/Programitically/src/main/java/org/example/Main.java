package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot x = new Parrot();
        x.setName("Koko");

        Supplier<Parrot> parrotSupplier = () -> x;

        // Bean Name, Supplier and BeanDefinitionCustomizer is optional

        context.registerBean("parrot1", Parrot.class, parrotSupplier, bc -> bc.setPrimary(true));
        context.registerBean("parrot2", Parrot.class);


        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
    }
}

@Configuration
class ProjectConfig { }

class Parrot {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}