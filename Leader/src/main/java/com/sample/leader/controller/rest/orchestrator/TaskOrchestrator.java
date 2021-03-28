package com.sample.leader.controller.rest.orchestrator;

import com.sample.leader.model.dto.task.StartTaskDto;
import com.sample.leader.model.dto.task.TaskDto;
import com.sample.leader.model.dto.task.TaskResultDto;
import com.sample.leader.model.entity.task.TaskResult;
import com.sample.leader.repository.AllRepository;
import com.sample.leader.transport.TransportApi;
import com.sample.leader.utils.Converter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Service
public class TaskOrchestrator extends Orchestrator{
    TransportApi transportApi;
    @Value("#{'${leader.worker.hosts}'.split(',')}")
    private List<String> hosts;


    @Autowired
    public TaskOrchestrator(Converter converter, AllRepository repositoryBuilder,
                            TransportApi transportApi) {
        super(converter, repositoryBuilder);
        this.transportApi = transportApi;
    }

    public TaskResultDto startExecuteTask(StartTaskDto startTask) throws ClassNotFoundException {
        TaskDto task = get(startTask.getIdTask(), TaskDto.class);
        TaskResultDto taskResult = null;
        String executorHost = null;
        for(String host : hosts) {
            if(transportApi.isAvailableWorker(host)) {
                executorHost = host;
                break;
            }
        }

        if(task != null && executorHost != null) {
            taskResult = new TaskResultDto();
            taskResult.setTask(task);
            taskResult.setAuthor(startTask.getAuthor());
            taskResult.setTimeStart(new Date().getTime());

            put(taskResult, TaskResultDto.class, TaskResult.class);
            transportApi.sendTask(executorHost + "/api/v1/task/start", task);
        }

        return taskResult;
    }

    public void putResultTask(TaskResultDto dto) throws ClassNotFoundException  {

    }
}
