package org.justinhoang.persistence;

import com.google.gson.*;
import org.justinhoang.entity.QuoteResp;

import java.lang.reflect.Type;

public class QuoteDao
        implements JsonDeserializer<QuoteResp>
{

    public QuoteResp deserialize(JsonElement json, Type typeOfT,
                                 JsonDeserializationContext context) throws
                                                                                                        JsonParseException
    {

        JsonObject proQuoteJson = json.getAsJsonObject();
        String     id           = proQuoteJson.get("id").getAsString();
        String     author       = proQuoteJson.get("author").getAsString();
        String     quote        = proQuoteJson.get("en").getAsString();

        QuoteResp quoteResp = new QuoteResp();
        quoteResp.setId(id);
        quoteResp.setAuthor(author);
        quoteResp.setQuote(quote);

        return quoteResp;
    }
}
