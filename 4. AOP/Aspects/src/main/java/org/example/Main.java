package org.example;

import org.example.aspects.LoggingAspect;
import org.example.model.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.*;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService = context.getBean(CommentService.class);

        Comment comment = new Comment("Learning Spring", "Ayush Sachan");
        commentService.publishComment(comment);
    }
}

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
class ProjectConfig {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}

