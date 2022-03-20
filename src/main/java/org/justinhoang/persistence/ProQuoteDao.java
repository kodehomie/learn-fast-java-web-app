package org.justinhoang.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.justinhoang.api.ProgrammingQuotes;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ProQuoteDao
{
    public ProgrammingQuotes getQuote()
    {
        Client client = ClientBuilder.newClient();
        //TODO read in uri from a properties file
        WebTarget target = client.target(
                "https://programming-quotes-api.herokuapp" +
                ".com/quotes/5a6ce86f2af929789500e824");
        String response =
                target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper      mapper            = new ObjectMapper();
        ProgrammingQuotes programmingQuotes = null;
        try
        {
            programmingQuotes =
                    mapper.readValue(response, ProgrammingQuotes.class);
        }
        catch (JsonProcessingException e)
        {
            //TODO set up logging and write this to the log
            e.printStackTrace();
        }
        return programmingQuotes;
    }
}
