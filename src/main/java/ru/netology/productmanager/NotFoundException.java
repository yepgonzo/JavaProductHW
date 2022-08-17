package ru.netology.productmanager;

public class NotFoundException extends RuntimeException {

    public NotFoundException (String error) {
        super(error);
    }
}
