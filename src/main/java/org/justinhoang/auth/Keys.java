package org.justinhoang.auth;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Keys.
 */
public class Keys
{

    @JsonProperty("keys")
    private List<KeysItem> keys;

    /**
     * Gets keys.
     *
     * @return the keys
     */
    public List<KeysItem> getKeys()
    {
        return keys;
    }
}
