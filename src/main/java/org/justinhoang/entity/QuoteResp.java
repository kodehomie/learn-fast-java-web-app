package org.justinhoang.entity;

import com.google.gson.annotations.SerializedName;

/**
 * The type Quote resp.
 */
public class QuoteResp
{

    @SerializedName("author")
    private String author;

    @SerializedName("en")
    private String quote;

    @SerializedName("id")
    private String id;

    /**
     * Set author.
     *
     * @param author
     *         the author
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }

    /**
     * Get author string.
     *
     * @return the string
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Set quote.
     *
     * @param quote
     *         the quote
     */
    public void setQuote(String quote)
    {
        this.quote = quote;
    }

    /**
     * Get en string.
     *
     * @return the string
     */
    public String getEn()
    {
        return quote;
    }

    /**
     * Set id.
     *
     * @param id
     *         the id
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * Get id string.
     *
     * @return the string
     */
    public String getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "QuoteResp{" + "author = '" + author + '\'' + ",quote = '" +
               quote + '\'' + ",id = '" + id + '\'' + "}";
    }
}