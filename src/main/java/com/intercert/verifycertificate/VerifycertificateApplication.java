package com.intercert.verifycertificate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VerifycertificateApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerifycertificateApplication.class, args);
    }

}
