package com.joaolubaw.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.joaolubaw.api"})
public class BackendApplication {

    public static void main(String[] args) {
        System.out.println("Diretório atual: " + new java.io.File(".").getAbsolutePath());
        SpringApplication.run(BackendApplication.class, args);
    }
}
