package com.sample.leader.controller.rest.orchestrator;

import com.sample.leader.repository.AllRepository;
import com.sample.leader.utils.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class Orchestrator {
    protected final Converter converter;
    protected final AllRepository repositoryBuilder;

    public List getAll(Class<?> dtoClass) throws ClassNotFoundException {
        return StreamSupport.stream(repositoryBuilder.getRepository(dtoClass).findAll().spliterator(), false)
                .map(el -> converter.convert(el, dtoClass))
                .collect(Collectors.toList());
    }

    public <Dto, IdType> Dto get(IdType id, Class<Dto> dtoClass) throws ClassNotFoundException {
        return converter.convert(repositoryBuilder.getRepository(dtoClass).findById(id).orElse(null), dtoClass);
    }
    
    public <Dto, Entity> Dto put(Dto dto, Class<Dto> dtoClass, Class<Entity> entityClass) throws ClassNotFoundException {
        Entity entity = converter.convert(dto, entityClass);
        entity = repositoryBuilder.getRepository(entityClass).save(entity);
        Dto saveDto = converter.convert(entity, dtoClass);
        return saveDto;       
    }

    public <Dto, Entity> Dto post(Dto dto, Class<Dto> dtoClass, Class<Entity> entityClass) throws ClassNotFoundException {
        Entity entity = converter.convert(dto, entityClass);
        entity = repositoryBuilder.getRepository(entityClass).save(entity);
        Dto saveDto = converter.convert(entity, dtoClass);
        return saveDto;
    }

    public <Dto, IdType> void delete(IdType id, Class<Dto> dtoClass) throws ClassNotFoundException {
        if(repositoryBuilder.getRepository(dtoClass).existsById(id)) {
            repositoryBuilder.getRepository(dtoClass).deleteById(id);
        }
    }

}
