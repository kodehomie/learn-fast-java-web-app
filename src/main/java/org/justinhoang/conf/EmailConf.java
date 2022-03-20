package org.justinhoang.conf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class EmailConf
{
    private final Logger     log = LogManager.getLogger(this.getClass());
    private       Properties prop;

    public EmailConf()
    {
        load();
    }

    private void load()
    {
        prop = new Properties();
        try
        {
            prop.load(this.getClass()
                          .getResourceAsStream("/javamailapi.properties"));
        }
        catch (IOException ioe)
        {
            log.error("Unable to load the properties file: " + ioe);
        }
        catch (Exception e)
        {
            log.error("Error: " + e);
        }
    }

    @Bean
    public SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("justinkhoang@icloud.com");
        message.setFrom(prop.getProperty("sender"));
        message.setSubject("Subject");
        message.setText("Body");
        return message;
    }

    @Bean
    public JavaMailSender getJavaMailSender()
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(prop.getProperty("sender"));
        mailSender.setPassword(prop.getProperty("password"));

        Properties prop = mailSender.getJavaMailProperties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.protocol", "smtp");
        prop.put("mail.smtp.socketFactory.port", "587");
        prop.put("mail.smtp.socketFactory.class",
                 "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }
}