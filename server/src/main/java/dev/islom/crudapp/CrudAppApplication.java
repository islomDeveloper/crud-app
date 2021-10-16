package dev.islom.crudapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudAppApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
