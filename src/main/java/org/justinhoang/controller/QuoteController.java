package org.justinhoang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * The type Quote controller.
 */
@RestController
public class QuoteController
{
    @GetMapping("/programming-quotes")
    private String Quote()
    {
        String       uri          =
                "https://programming-quotes-api.herokuapp.com/quotes/random";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}
