package org.justinhoang.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProgrammingQuotes
{

    @JsonProperty("author")
    private String author;

    @JsonProperty("en")
    private String en;

    @JsonProperty("id")
    private String id;

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setEn(String en)
    {
        this.en = en;
    }

    public String getEn()
    {
        return en;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "ProgrammingQuotes{" + "author = '" + author + '\'' + ",en = '" +
               en + '\'' + ",id = '" + id + '\'' + "}";
    }
}