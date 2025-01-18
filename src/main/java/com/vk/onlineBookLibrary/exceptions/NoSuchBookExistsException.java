package com.vk.onlineBookLibrary.exceptions;

public class NoSuchBookExistsException extends RuntimeException {
    public NoSuchBookExistsException() {
    }

    public NoSuchBookExistsException(String message) {
        super(message);
    }
}
