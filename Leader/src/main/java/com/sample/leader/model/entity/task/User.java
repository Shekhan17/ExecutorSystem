package com.sample.leader.model.entity.task;

import com.sample.leader.model.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="users")
public class User extends BaseEntity<Long> {
    @Column(name = "username")
    private String userName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_tasks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;

    public User(){
        this.tasks = new ArrayList<>();
    }


}
