package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/")
public class DemoController {
    private RestTemplate restTemplate;
    @Autowired
    public DemoController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @GetMapping("callRemoteUrl")
    public ResponseEntity<String> callRemoteUrl() throws URISyntaxException {
        final String baseUrl = "https://uat.darumatic.com/static/response.json";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        return forEntity;
    }
}
