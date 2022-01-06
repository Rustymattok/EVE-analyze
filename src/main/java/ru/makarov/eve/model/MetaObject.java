package ru.makarov.eve.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class MetaObject<T> {
    private T meta;

    public MetaObject(T meta) {
        this.meta = meta;
    }
}