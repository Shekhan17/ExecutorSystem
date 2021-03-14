package com.sample.leader.controller.rest.orchestrator;

import com.sample.leader.model.dto.task.StartTaskDto;
import com.sample.leader.model.dto.task.TaskDto;
import com.sample.leader.model.dto.task.TaskResultDto;
import com.sample.leader.model.entity.task.TaskResult;
import com.sample.leader.repository.AllRepository;
import com.sample.leader.utils.Converter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter
@Setter
@Service
public class TaskOrchestrator extends Orchestrator{
    public TaskOrchestrator(Converter converter, AllRepository repositoryBuilder) {
        super(converter, repositoryBuilder);
    }

    public TaskResultDto startExecuteTask(StartTaskDto startTask) throws ClassNotFoundException {
        TaskDto task = get(startTask.getIdTask(), TaskDto.class);
        TaskResultDto taskResult = null;
        if(task != null) {
            taskResult = new TaskResultDto();
            taskResult.setTask(task);
            taskResult.setAuthor(startTask.getAuthor());
            taskResult.setTimeStart(new Date().getTime());

            put(taskResult, TaskResultDto.class, TaskResult.class);
        }

        return taskResult;
    }
}
