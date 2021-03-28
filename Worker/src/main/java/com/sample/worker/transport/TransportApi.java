package com.sample.worker.transport;

public interface TransportApi {

    void sendResultTask(String host, Long id, String result, Long timeEnd);

}
