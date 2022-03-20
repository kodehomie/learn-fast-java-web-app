package org.justinhoang;

import org.justinhoang.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class LearnFastApplication implements CommandLineRunner
{
    @Autowired
    private EmailService emailService;

    public static void main(String[] args)
    {
        SpringApplication.run(LearnFastApplication.class, args);
    }

    @Override
    public void run(String... args)
    {
//        emailService.sendMail("justinkhoang@icloud.com", "Subject", "Body");
//
//        emailService.sendPreConfiguredMail("HelloWorld");
    }
}
