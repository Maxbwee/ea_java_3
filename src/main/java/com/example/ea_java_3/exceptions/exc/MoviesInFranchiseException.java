package com.example.ea_java_3.exceptions.exc;

public class MoviesInFranchiseException extends ApiRuntimeException{
    public MoviesInFranchiseException(int count) {
        super("Cannot delete the franchise, since " + count + " movie(s) belong to it. To delete the franchise, remove the existing movie(s) first.");
    }
}
