package ru.javawebinar.basejava.util;

public class LazySingleton {
    private static final LazySingleton INSTANCE = new LazySingleton();

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        return INSTANCE;
    }


}
