package com.sample.leader.utils;

public interface Converter {
    <Original, Converted> Converted convert(Original entity, Class<Converted> clazz);
}
