package io.shelfy.db_creator_appl;

import io.shelfy.db_creator_appl.service.DBCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class DbCreatorApplApplication {

    public static void main(String[] args) throws IOException {

        ConfigurableApplicationContext ctx = SpringApplication.run(DbCreatorApplApplication.class, args);
        DBCreator dbCreator = ctx.getBean(DBCreator.class);
        dbCreator.addCallers();
        dbCreator.addCalls();
        ctx.close();
    }
}
