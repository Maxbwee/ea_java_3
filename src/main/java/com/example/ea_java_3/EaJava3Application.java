package com.example.ea_java_3;

import com.example.ea_java_3.http.controller.FranchiseController;
import lombok.val;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EaJava3Application implements ApplicationRunner {
    private final FranchiseController c;

    public EaJava3Application(FranchiseController c) {
        this.c = c;
    }

    public static void main(String[] args) {
        SpringApplication.run(EaJava3Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}
