package org.justinhoang.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.justinhoang.conf.EmailConf;
import org.justinhoang.service.EmailService;

class SendEmailTest
{

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    void sendEmail()
    {
        EmailConf emailConf = new EmailConf();
        emailConf.emailTemplate();
        emailConf.getJavaMailSender();
        EmailService emailService = new EmailService();
        emailService.sendMail();
    }
}
