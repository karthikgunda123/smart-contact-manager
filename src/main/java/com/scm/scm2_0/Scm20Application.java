package com.scm.scm2_0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Scm20Application {
    public static void main(String[] args) {
        SpringApplication.run(Scm20Application.class, args);
        System.out.println("Working....");
    }
    // npx tailwindcss -i src/main/resources/static/css/input.css -o src/main/resources/static/css/output.css --watch
}
