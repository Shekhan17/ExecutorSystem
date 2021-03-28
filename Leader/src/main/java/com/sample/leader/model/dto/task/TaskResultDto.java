package com.sample.leader.model.dto.task;

import com.sample.leader.model.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResultDto extends BaseDto<Long> {
    private String author;
    private Long timeStart;
    private Long timeEnd;
    private String result;
    private Boolean isEnd;
    private Boolean success;
    private TaskDto task;

}
