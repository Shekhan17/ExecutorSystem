package com.sample.leader.repository;

import com.sample.leader.model.entity.task.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
}
