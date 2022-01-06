package ru.makarov.eve.model.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiFieldError {
    private String objectName;
    private String field;
    private String code;
    private Object rejectedValue;
    private String message;
    @JsonIgnore
    private String error;
}
