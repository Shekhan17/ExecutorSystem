package com.sample.worker.service;

import com.sample.worker.model.TaskInfoDTO;
import com.sample.worker.transport.TransportApi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
@AllArgsConstructor
public class TaskMockExecutor implements TaskExecutor {

    TransportApi transportApi;

    @Override
    public void startTaskExecute(TaskInfoDTO taskInfoDTO) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(new TaskCallable(taskInfoDTO.getInstruction(), taskInfoDTO.getExecuteTime()));
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        transportApi.sendResultTask(taskInfoDTO.getHost(), taskInfoDTO.getId(), result, new Date().getTime());
    }

}
