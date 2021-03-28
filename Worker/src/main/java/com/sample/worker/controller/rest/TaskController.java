package com.sample.worker.controller.rest;

import com.sample.worker.model.TaskInfoDTO;
import com.sample.worker.service.TaskExecutor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    TaskExecutor taskExecutor;

    @PostMapping("/start")
    public void startExecuteTask(@RequestBody TaskInfoDTO taskInfoDTO) {
        taskExecutor.startTaskExecute(taskInfoDTO);
    }
}
