package com.sample.leader.repository;

import com.sample.leader.model.entity.task.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
