package ru.netology.productmanager;

public class IdNotFound extends RuntimeException {

    public IdNotFound (String error) {
        super(error);
    }
}
