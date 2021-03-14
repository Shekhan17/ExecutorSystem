package com.sample.leader.model.dto.task;

import com.sample.leader.model.dto.BaseDto;
import com.sample.leader.model.entity.task.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class UserDto extends BaseDto<Long> {
    private String userName;
    private List<Task> tasks;

    public UserDto(){
        this.tasks = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(userName, userDto.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userName);
    }

}
