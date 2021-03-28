package com.sample.worker.service;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class TaskCallable implements Callable<String> {

    final String instruction;
    final Long executeTime;

    @Override
    public String call() throws Exception {
        Thread.sleep(executeTime * 1000);
        return "Task execute!";
    }
}
