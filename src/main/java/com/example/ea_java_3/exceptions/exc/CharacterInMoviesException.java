package com.example.ea_java_3.exceptions.exc;


public class CharacterInMoviesException extends ApiRuntimeException {
    public CharacterInMoviesException(int count)  {
        super("This character appears in " + count + " movie(s), and cannot be deleted. Delete the character from the movies first.");
    }
}
