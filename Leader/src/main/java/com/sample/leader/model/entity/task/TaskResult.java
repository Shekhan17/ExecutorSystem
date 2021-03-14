package com.sample.leader.model.entity.task;

import com.sample.leader.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="task_results")
public class TaskResult extends BaseEntity<Long> {

    @Column(name = "author")
    String author;
    @Column(name = "time_start")
    Long timeStart;
    @Column(name = "time_end")
    Long timeEnd;
    @Column(name = "is_end")
    Boolean isEnd = false;
    @Column(name = "success")
    Boolean success= false;

    @ManyToOne
    @JoinColumn(name = "task")
    private Task task;
}
