package com.sample.leader.model.dto.task;

import com.sample.leader.model.dto.BaseDto;
import com.sample.leader.model.entity.task.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class TaskDto extends BaseDto<Long> {
    private String description;
    private String instruction;
    private Long timeExecute;
    private List<User> users;

    public TaskDto() {
        this.users = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TaskDto taskDto = (TaskDto) o;
        return Objects.equals(description, taskDto.description) && Objects.equals(instruction, taskDto.instruction) && Objects.equals(timeExecute, taskDto.timeExecute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, instruction, timeExecute);
    }
}
