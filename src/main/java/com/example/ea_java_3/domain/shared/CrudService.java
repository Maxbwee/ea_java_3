package com.example.ea_java_3.domain.shared;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, U> {
    T create(U dto);

    T getById(int id);

    List<T> getAll();

    void deleteById(int id);

    T update(int id, U dto);
}
