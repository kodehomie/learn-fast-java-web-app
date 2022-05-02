package org.justinhoang.controller;

import java.time.Instant;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
class ErrorController
{

    @RequestMapping("/error")
    ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request)
    {
        HttpStatus httpStatus = HttpStatus.valueOf((int) request.getAttribute(
                RequestDispatcher.ERROR_STATUS_CODE));
        Map<String, Object> body = Map.of("status", httpStatus.value(), "error",
                                          httpStatus.getReasonPhrase(), "path",
                                          request.getAttribute(
                                                  RequestDispatcher.ERROR_REQUEST_URI),
                                          "timestamp",
                                          Instant.now().toEpochMilli());
        return new ResponseEntity<>(body, httpStatus);
    }

}
