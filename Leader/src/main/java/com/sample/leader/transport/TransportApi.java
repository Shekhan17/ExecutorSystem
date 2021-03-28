package com.sample.leader.transport;

import com.sample.leader.model.dto.task.TaskDto;

public interface TransportApi {
    Boolean isAvailableWorker(String host);
    void sendTask(String host, TaskDto task);

}
