package com.sample.leader.transport.rest;

import com.sample.leader.transport.TransportApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RestTransport implements TransportApi {
    RestTemplate restTemplate;

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
    public Set<String> getAllAvailableWorkers() {

        return null;
    }

    @Override
    public void sendTask(String host) {

    }

    @Override
    public List<Map<String, String>> getResultTasks(String host) {
        return null;
    }
}
