package org.justinhoang;

import org.justinhoang.service.ActivityService;
import org.justinhoang.service.QuoteService;

import java.io.IOException;

public class TestDriver
{
    public static void main(String[] args) throws IOException
    {
        QuoteService quoteService = new QuoteService();
        quoteService.QuoteService();
        ActivityService activityService = new ActivityService();
        activityService.ActivityService();
    }
}
