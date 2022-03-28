package org.justinhoang.exception;

/**
 * The type Resource not found exception.
 */
public class ResourceNotFoundException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param id
     *         the id
     */
    public ResourceNotFoundException(Object id)
    {
        super(id != null ? id.toString() : null);
    }
}

