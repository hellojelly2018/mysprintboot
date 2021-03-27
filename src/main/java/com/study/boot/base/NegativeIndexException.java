package com.study.boot.base;

/**
 * @author Yangjiali
 * @create 2021-03-21:12 21:12
 */
public class NegativeIndexException extends RuntimeException {
    public NegativeIndexException() {
        super();
    }

    public NegativeIndexException(String message) {
        super(message);
    }
}
