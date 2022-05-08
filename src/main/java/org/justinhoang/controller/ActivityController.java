package org.justinhoang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * The type Activity controller.
 */
@RestController
public class ActivityController
{
    @GetMapping("/activity-generator")
    private String Activity()
    {
        String       uri          =
                "https://www.boredapi.com/api/activity/";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, String.class);
    }
}
