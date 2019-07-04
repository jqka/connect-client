package com.connect.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class IndexController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping({"/", "/index"})
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.html");
    }

    @RequestMapping(value = "/submit", produces = "text/plain")
    public String submit(@RequestParam String url) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);


        String body = " return\n";
        body += restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();

        return body;
    }

}
