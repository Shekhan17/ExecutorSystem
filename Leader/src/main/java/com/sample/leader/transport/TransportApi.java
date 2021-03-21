package com.sample.leader.transport;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TransportApi {
    Boolean isAvailableWorker(String host);
    Set<String> getAllAvailableWorkers();
    void sendTask(String host);
    List<Map<String, String>> getResultTasks(String host);

}
