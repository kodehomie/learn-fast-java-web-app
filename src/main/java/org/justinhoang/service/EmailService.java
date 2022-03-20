package org.justinhoang.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.conf.EmailConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service("emailService")
public class EmailService
{
    private final Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    private JavaMailSender    mailSender;
    @Autowired
    private SimpleMailMessage preConfiguredMessage;

    public void sendMail()
    {
        EmailConf emailConf = new EmailConf();
        emailConf.emailTemplate();
    }

    public void sendMail(String recipient, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

    /**
     * This method will send a pre-configured message
     */
    public void sendPreConfiguredMail(String message)
    {
        SimpleMailMessage mailMessage =
                new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }

    public void sendMailWithAttachment(String recipient, String subject,
                                       String body, String fileToAttach)
    {
        MimeMessagePreparator preparator = new MimeMessagePreparator()
        {
            public void prepare(MimeMessage mimeMessage) throws Exception
            {
                mimeMessage.setRecipient(Message.RecipientType.TO,
                                         new InternetAddress(recipient));
                mimeMessage.setFrom(new InternetAddress("sender@gmail.com"));
                mimeMessage.setSubject(subject);
                mimeMessage.setText(body);

                FileSystemResource file =
                        new FileSystemResource(new File(fileToAttach));
                MimeMessageHelper helper =
                        new MimeMessageHelper(mimeMessage, true);
                helper.addAttachment("logo.jpg", file);
            }
        };

        try
        {
            mailSender.send(preparator);
        }
        catch (MailException e)
        {
            log.error(e.getMessage());
        }
    }

    public void sendMailWithInlineResources(String recipient, String subject,
                                            String fileToAttach)
    {
        MimeMessagePreparator preparator = new MimeMessagePreparator()
        {
            public void prepare(MimeMessage mimeMessage) throws Exception
            {
                mimeMessage.setRecipient(Message.RecipientType.TO,
                                         new InternetAddress(recipient));
                mimeMessage.setFrom(new InternetAddress("sender@gmail.com"));
                mimeMessage.setSubject(subject);

                MimeMessageHelper helper =
                        new MimeMessageHelper(mimeMessage, true);

                helper.setText("<html><body><img " +
                               "src='cid:identifier000'></body></html>", true);

                FileSystemResource res =
                        new FileSystemResource(new File(fileToAttach));
                helper.addInline("identifier000", res);
            }
        };

        try
        {
            mailSender.send(preparator);
        }
        catch (MailException e)
        {
            log.error(e.getMessage());
        }
    }
}
