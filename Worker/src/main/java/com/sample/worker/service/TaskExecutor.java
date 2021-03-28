package com.sample.worker.service;

import com.sample.worker.model.TaskInfoDTO;

public interface TaskExecutor {
    void startTaskExecute(TaskInfoDTO taskInfoDTO);
}
