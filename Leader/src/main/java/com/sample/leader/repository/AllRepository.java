package com.sample.leader.repository;

import com.sample.leader.model.dto.task.TaskDto;
import com.sample.leader.model.dto.task.UserDto;
import com.sample.leader.model.entity.task.Task;
import com.sample.leader.model.entity.task.TaskResult;
import com.sample.leader.model.entity.task.User;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AllRepository {
    UserRepository userRepository;
    TaskRepository taskRepository;
    TaskResultRepository taskResultRepository;

    public <IdType, EntityType, T extends CrudRepository<EntityType, IdType>> T getRepository(Class clazz) throws ClassNotFoundException {
        if(UserDto.class.isAssignableFrom(clazz)) {
            return (T)userRepository;
        } else if(User.class.isAssignableFrom(clazz)) {
            return (T)userRepository;
        } else if(TaskDto.class.isAssignableFrom(clazz)) {
            return (T)taskRepository;
        } else if(Task.class.isAssignableFrom(clazz)) {
            return (T)taskRepository;
        } else if(TaskResultRepository.class.isAssignableFrom(clazz)) {
            return (T)taskResultRepository;
        } else if(TaskResult.class.isAssignableFrom(clazz)) {
            return (T)taskResultRepository;
        }

        throw new ClassNotFoundException("Repository not found!!");

    }

}
