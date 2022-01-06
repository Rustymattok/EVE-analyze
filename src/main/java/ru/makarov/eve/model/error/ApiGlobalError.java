package ru.makarov.eve.model.error;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiGlobalError {
    private String message;
}
