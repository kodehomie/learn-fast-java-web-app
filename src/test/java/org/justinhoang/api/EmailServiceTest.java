//package org.justinhoang.api;
//
//import org.apache.cxf.jaxrs.client.WebClient;
//import org.apache.openejb.jee.WebApp;
//import org.apache.openejb.junit.ApplicationComposer;
//import org.apache.openejb.testing.Classes;
//import org.apache.openejb.testing.EnableServices;
//import org.apache.openejb.testing.Module;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.justinhoang.service.EmailService;
//
//import java.io.IOException;
//
//import static org.junit.Assert.assertEquals;
//
//@EnableServices(value = "jaxrs")
//@RunWith(ApplicationComposer.class)
//public class EmailServiceTest
//{
//    @Module
//    @Classes(EmailService.class)
//    public WebApp app()
//    {
//        return new WebApp().contextRoot("test");
//    }
//
//    @Test
//    public void post() throws IOException
//    {
//        final String msg =
//                WebClient.create("http://localhost:4204").path("/test/email/")
//                         .post("BODY", String.class);
//        assertEquals("Failed to send message: Unknown SMTP host: your" +
//                     ".mailserver.host ", msg);
//    }
//}