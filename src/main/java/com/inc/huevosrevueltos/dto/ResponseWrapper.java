package com.inc.huevosrevueltos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class ResponseWrapper<T> {
    private T data;
}
