package org.justinhoang.api;

import org.junit.jupiter.api.Test;
import org.justinhoang.persistence.ProQuoteDao;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProQuoteDaoTest
{
    @Test
    void getQuoteSuccess()
    {
        ProQuoteDao dao = new ProQuoteDao();
        assertEquals(
                "One of my most productive days was throwing away 1,000 lines" +
                " of code.", dao.getQuote().getEn());
    }
}
