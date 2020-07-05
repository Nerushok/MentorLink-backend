package com.mentor.link.utils;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<From, To> {

    To map(From fromData);

    default List<To> map(List<From> fromData) {
        return fromData.stream().map(this::map).collect(Collectors.toList());
    }
}
