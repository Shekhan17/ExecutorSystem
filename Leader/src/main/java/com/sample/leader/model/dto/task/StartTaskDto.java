package com.sample.leader.model.dto.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StartTaskDto {
    private String author;
    private long idTask;
}
