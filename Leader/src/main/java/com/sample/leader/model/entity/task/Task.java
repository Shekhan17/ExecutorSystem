package com.sample.leader.model.entity.task;

import com.sample.leader.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="tasks")
public class Task extends BaseEntity<Long> {

    @Column(name = "description")
    String description;
    @Column(name = "instruction")
    String instruction;
    @Column(name = "time_execute")
    Long timeExecute;

    @ManyToMany
    @JoinTable(name = "users_tasks",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @OneToMany(mappedBy = "task")
    private List<TaskResult> taskResults;


    public Task() {
        this.users = new ArrayList<>();
    }
}
