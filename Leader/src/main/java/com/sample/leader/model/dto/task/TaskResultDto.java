package com.sample.leader.model.dto.task;

import com.sample.leader.model.dto.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class TaskResultDto extends BaseDto<Long> {
    private String author;
    private Long timeStart;
    private Long timeEnd;
    private Boolean isEnd;
    private Boolean success;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TaskResultDto that = (TaskResultDto) o;
        return Objects.equals(author, that.author) && Objects.equals(timeStart, that.timeStart) && Objects.equals(timeEnd, that.timeEnd) && Objects.equals(isEnd, that.isEnd) && Objects.equals(success, that.success) && Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, timeStart, timeEnd, isEnd, success, task);
    }

    private TaskDto task;

}
