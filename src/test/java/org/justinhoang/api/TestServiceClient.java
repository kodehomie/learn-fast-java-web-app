package org.justinhoang.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient
{

    @Test
    public void testRestApiJSON() throws Exception
    {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(
                "https://programming-quotes-api.herokuapp" +
                ".com/quotes/5a6ce86f2af929789500e824");
                String response = target.request(MediaType.APPLICATION_JSON)
                                        .get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        ProgrammingQuotes programmingQuotes =
                mapper.readValue(response, ProgrammingQuotes.class);
        String expectedProgrammingQuote =
                "One of my most productive days was throwing away 1,000 lines" +
                " of code.";
        assertEquals(expectedProgrammingQuote, programmingQuotes.getEn());
        //        assertEquals("

    }

}
