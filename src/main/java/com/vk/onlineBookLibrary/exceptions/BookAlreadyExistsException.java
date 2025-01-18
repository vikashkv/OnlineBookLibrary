package com.vk.onlineBookLibrary.exceptions;

public class BookAlreadyExistsException extends RuntimeException {

    public BookAlreadyExistsException() {
    }

    public BookAlreadyExistsException(String message) {
        super(message);
    }
}
