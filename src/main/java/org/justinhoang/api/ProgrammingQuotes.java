package org.justinhoang.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Programming quotes.
 */
public class ProgrammingQuotes
{

    @JsonProperty("author")
    private String author;

    @JsonProperty("en")
    private String en;

    @JsonProperty("id")
    private String id;

    /**
     * Sets author.
     *
     * @param author
     *         the author
     */
    public void setAuthor(final String author)
    {
        this.author = author;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Sets en.
     *
     * @param en
     *         the en
     */
    public void setEn(final String en)
    {
        this.en = en;
    }

    /**
     * Gets en.
     *
     * @return the en
     */
    public String getEn()
    {
        return en;
    }

    /**
     * Sets id.
     *
     * @param id
     *         the id
     */
    public void setId(final String id)
    {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
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
