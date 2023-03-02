package com.example.ea_java_3.exceptions.exc;

import com.example.ea_java_3.exceptions.exc.ApiRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FranchiseNotFoundException extends ApiRuntimeException {
    public FranchiseNotFoundException(int id) {
        super("Franchise does not exist with ID: " + id);
    }


}
