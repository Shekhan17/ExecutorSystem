package com.sample.worker.transport.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.worker.transport.TransportApi;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
public class RestTransport implements TransportApi {
    RestTemplate restTemplate;

    public RestTransport() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public void sendResultTask(String host, Long id, String result, Long timeEnd) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", id);
        requestBody.put("result", result);
        requestBody.put("timeEnd", timeEnd);
        requestBody.put("success", true);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        restTemplate.postForEntity(host + "/api/v1/task/putResult", entity, String.class);
    }
}
