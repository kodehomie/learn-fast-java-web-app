package org.justinhoang.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class SendEmailTest
{

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    void sendEmail()
    {
        SendEmail send = new SendEmail();
        send.SMTP("subject test", "message test (success)");
    }
}
