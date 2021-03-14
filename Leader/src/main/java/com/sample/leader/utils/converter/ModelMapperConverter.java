package com.sample.leader.utils.converter;

import com.sample.leader.utils.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ModelMapperConverter implements Converter {

    private ModelMapper mapper;

    public ModelMapperConverter() {
        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setSkipNullEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    public <Original, Converted> Converted convert(Original entity, Class<Converted> clazz) {
        return Objects.isNull(entity) ? null
                : mapper.map(entity, clazz);
    }


}
