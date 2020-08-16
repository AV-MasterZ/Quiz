package org.zhadaev.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.zhadaev.answers.AnswersApp;
import org.zhadaev.constructor.ConstructorApp;
import org.zhadaev.questionnaires.QuestionnairesApp;
import org.zhadaev.user.UserApp;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Application.class,
                        UserApp.class,
                        ConstructorApp.class,
                        QuestionnairesApp.class,
                        AnswersApp.class)
                .run(args);
    }

}