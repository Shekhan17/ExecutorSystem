package com.sample.leader.controller.rest;

import com.sample.leader.controller.rest.orchestrator.Orchestrator;
import com.sample.leader.controller.rest.orchestrator.TaskOrchestrator;
import com.sample.leader.model.dto.task.StartTaskDto;
import com.sample.leader.model.dto.task.TaskDto;
import com.sample.leader.model.dto.task.TaskResultDto;
import com.sample.leader.model.entity.task.Task;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private TaskOrchestrator orchestrator;

    @GetMapping
    public List getAll() throws ClassNotFoundException {
        return orchestrator.getAll(TaskDto.class);
    }

    @GetMapping("/{id}")
    public TaskDto get(@PathVariable Long id) throws ClassNotFoundException {
        return orchestrator.get(id, TaskDto.class);
    }

    @PutMapping
    public TaskDto put(@RequestBody TaskDto dto) throws ClassNotFoundException {
        return orchestrator.put(dto, TaskDto.class, Task.class);
    }

    @PostMapping
    public TaskDto post(@RequestBody TaskDto dto) throws ClassNotFoundException {
        return orchestrator.post(dto, TaskDto.class, Task.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ClassNotFoundException {
        orchestrator.delete(id, TaskDto.class);
    }

    @PostMapping("/start")
    public TaskResultDto startExecuteTask(@RequestBody StartTaskDto dto) throws ClassNotFoundException {
        return orchestrator.startExecuteTask(dto);
    }

    @PostMapping("/putResult")
    public void putResultTask(@RequestBody TaskResultDto dto) throws ClassNotFoundException {
        orchestrator.putResultTask(dto);
    }

}
