package org.justinhoang.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.QuoteResp;
import org.justinhoang.persistence.QuoteDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

/**
 * The type Quote service.
 */
public class QuoteService
{
    private final     Logger     log = LogManager.getLogger(QuoteService.class);
    private           Properties prop;

    /**
     * Instantiates a new Activity service.
     */
    public QuoteService()
    {
        load();
    }

    private void load()
    {
        prop = new Properties();
        try
        {
            prop.load(this.getClass().getResourceAsStream("/api.properties"));
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

    /**
     * Quote service.
     *
     * @throws IOException
     *         the io exception
     */
    public void QuoteService() throws IOException
    {
        String url = prop.getProperty("quote.uri");

        String content = fetchContent(url);
        Gson gson = new GsonBuilder().registerTypeAdapter(QuoteResp.class,
                                                          new QuoteDao())
                                     .serializeNulls().create();

        QuoteResp quoteResp = gson.fromJson(content, new TypeToken<QuoteResp>()
        {
        }.getType());
        log.info(quoteResp);
        System.out.println(quoteResp);
    }

    private static String fetchContent(String uri) throws IOException
    {

        final int         OK         = 200;
        URL               url        = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        int responseCode = connection.getResponseCode();
        if (responseCode == OK)
        {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String       inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null)
            {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        }

        return null;
    }
}

