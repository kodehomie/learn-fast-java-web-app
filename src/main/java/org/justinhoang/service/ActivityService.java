package org.justinhoang.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.justinhoang.entity.ActivityResp;
import org.justinhoang.persistence.ActivityDao;
import org.justinhoang.util.PropLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

/**
 * The type Activity service.
 */
public class ActivityService implements PropLoader
{
    private final Logger     log = LogManager.getLogger(ActivityService.class);
    private       Properties prop;

    /**
     * Instantiates a new Activity service.
     */
    public ActivityService()
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
     * Activity service.
     *
     * @throws IOException
     *         the io exception
     */
    public void ActivityService() throws IOException
    {
        String url = prop.getProperty("activity.uri");

        String content = fetchContent(url);
        Gson gson = new GsonBuilder().registerTypeAdapter(ActivityResp.class,
                                                          new ActivityDao())
                                     .serializeNulls().create();

        ActivityResp activityResp =
                gson.fromJson(content, new TypeToken<ActivityResp>()
                {
                }.getType());
        log.info(activityResp);
        System.out.println(activityResp);
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

