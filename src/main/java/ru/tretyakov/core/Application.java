package ru.tretyakov.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @author A.Tretyakov.
 * @since 28.09.19
 */
@SpringBootApplication
@EntityScan(value = "ru.tretyakov.data")
@EnableJpaRepositories(value = "ru.tretyakov.data")
@ImportResource("classpath:ctx-config.xml")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
