package com.sample.leader.transport.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.leader.model.dto.task.TaskDto;
import com.sample.leader.transport.TransportApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class RestTransport implements TransportApi {
    RestTemplate restTemplate;

    @Value("${server.port}")
    String ModulePort;

    public RestTransport() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public Boolean isAvailableWorker(String host) {
        boolean isAvailable = false;
        try {
            restTemplate.headForHeaders(host);
            isAvailable = true;
        } catch (HttpClientErrorException ex) {
            isAvailable = ex.getStatusCode().value() < 500;
        }  catch (RestClientException ex) {

        }
        return isAvailable;
    }

    @Override
    public void sendTask(String host, TaskDto task) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", task.getId());
        requestBody.put("host", "http://localhost:" + ModulePort);
        requestBody.put("instruction", task.getInstruction());
        requestBody.put("executeTime", task.getTimeExecute());

        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<String> entity = new HttpEntity<>(json, headers);
        restTemplate.postForEntity(host, entity, String.class);
    }

}
