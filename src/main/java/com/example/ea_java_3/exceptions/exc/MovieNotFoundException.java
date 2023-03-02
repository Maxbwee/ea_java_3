package com.example.ea_java_3.exceptions.exc;

import com.example.ea_java_3.exceptions.exc.ApiRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends ApiRuntimeException {
    public MovieNotFoundException(int id) {
        super("Movie does not exist with ID: " + id);
    }
}
