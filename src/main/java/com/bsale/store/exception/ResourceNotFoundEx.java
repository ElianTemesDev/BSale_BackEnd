package com.bsale.store.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundEx extends RuntimeException{
    private final String resourceName;
    private final String fieldName;
    private final Object fieldValue;

    public ResourceNotFoundEx(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found, field %s : %s ", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
