package org.justinhoang.entity;

import com.google.gson.annotations.SerializedName;

/**
 * The type Activity resp.
 */
public class ActivityResp
{

    @SerializedName("activity")
    private String activity;

    @SerializedName("accessibility")
    private double accessibility;

    @SerializedName("price")
    private int price;

    @SerializedName("link")
    private String link;

    @SerializedName("type")
    private String type;

    @SerializedName("key")
    private String key;

    @SerializedName("participants")
    private int participants;

    /**
     * Sets activity.
     *
     * @param activity
     *         the activity
     */
    public void setActivity(String activity)
    {
        this.activity = activity;
    }

    /**
     * Gets activity.
     *
     * @return the activity
     */
    public String getActivity()
    {
        return activity;
    }

    /**
     * Sets accessibility.
     *
     * @param accessibility
     *         the accessibility
     */
    public void setAccessibility(double accessibility)
    {
        this.accessibility = accessibility;
    }

    /**
     * Gets accessibility.
     *
     * @return the accessibility
     */
    public double getAccessibility()
    {
        return accessibility;
    }

    /**
     * Sets price.
     *
     * @param price
     *         the price
     */
    public void setPrice(int price)
    {
        this.price = price;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Sets link.
     *
     * @param link
     *         the link
     */
    public void setLink(String link)
    {
        this.link = link;
    }

    /**
     * Gets link.
     *
     * @return the link
     */
    public String getLink()
    {
        return link;
    }

    /**
     * Sets type.
     *
     * @param type
     *         the type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets key.
     *
     * @param key
     *         the key
     */
    public void setKey(String key)
    {
        this.key = key;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public String getKey()
    {
        return key;
    }

    /**
     * Sets participants.
     *
     * @param participants
     *         the participants
     */
    public void setParticipants(int participants)
    {
        this.participants = participants;
    }

    /**
     * Gets participants.
     *
     * @return the participants
     */
    public int getParticipants()
    {
        return participants;
    }

    @Override
    public String toString()
    {
        return "ActivityResp{" + "activity = '" + activity + '\'' +
               ",accessibility = '" + accessibility + '\'' + ",price = '" +
               price + '\'' + ",link = '" + link + '\'' + ",type = '" + type +
               '\'' + ",key = '" + key + '\'' + ",participants = '" +
               participants + '\'' + "}";
    }
}