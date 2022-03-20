package org.justinhoang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class LearnFastApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(LearnFastApplication.class, args);
    }
}
