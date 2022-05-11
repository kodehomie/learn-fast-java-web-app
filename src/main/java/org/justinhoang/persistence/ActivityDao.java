package org.justinhoang.persistence;

import com.google.gson.*;
import org.justinhoang.entity.ActivityResp;

import java.lang.reflect.Type;

/**
 * The type Activity dao.
 */
public class ActivityDao implements JsonDeserializer<ActivityResp>
{

    public ActivityResp deserialize(JsonElement json, Type typeOfT,
                                    JsonDeserializationContext context) throws
                                                                                                        JsonParseException
    {

        JsonObject activityJson = json.getAsJsonObject();
        String     activity     = activityJson.get("activity").getAsString();
        String     type         = activityJson.get("type").getAsString();
        int        participants = activityJson.get("participants").getAsInt();
        int        price        = activityJson.get("price").getAsInt();
        String     link         = activityJson.get("link").getAsString();
        String     key          = activityJson.get("key").getAsString();
        double accessibility = activityJson.get("accessibility").getAsDouble();

        ActivityResp activityResp = new ActivityResp();
        activityResp.setActivity(activity);
        activityResp.setType(type);
        activityResp.setParticipants(participants);
        activityResp.setPrice(price);
        activityResp.setLink(link);
        activityResp.setKey(key);
        activityResp.setAccessibility(accessibility);

        return activityResp;
    }
}
