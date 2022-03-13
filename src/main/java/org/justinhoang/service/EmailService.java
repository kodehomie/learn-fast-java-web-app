package org.justinhoang.service;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Date;
import java.util.Properties;

@Path("/email")
public class EmailService
{
    @POST
    public String lowerCase(final String message)
    {
        try
        {
            //Create some properties and get the default Session
            final Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.debug", "true");
            final Session session =
                    Session.getInstance(props, new Authenticator()
                    {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication()
                        {
                            return new PasswordAuthentication("MyUsername",
                                                              "MyPassword");
                        }
                    });
            //Set this just to see some internal logging
            session.setDebug(true);
            //Create a message
            final MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("sender@host.com"));
            final InternetAddress[] address =
                    {new InternetAddress("addy@host.com")};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("JavaMail API test");
            msg.setSentDate(new Date());
            msg.setText(message, "UTF-8");
            Transport.send(msg);
        }
        catch (AddressException e)
        {
            return "Failed to send message: " + e.getMessage();
        }
        catch (MessagingException e)
        {
            return "Failed to send message: " + e.getMessage();
        }
        return "Sent";
    }
}