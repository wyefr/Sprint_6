package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane;
    private Feline feline;

    private Lion() {
    }

    public static Lion getInstance(String sex, Feline feline) throws IllegalArgumentException {
        Lion lion = new Lion();
        lion.feline = feline;
        if ("Самец".equals(sex)) {
            lion.hasMane = true;
        } else if ("Самка".equals(sex)) {
            lion.hasMane = false;
        } else {
            throw new IllegalArgumentException("Используйте допустимые значения пола животного - самец или самка");
        }
        return lion;
    }

    public int getKittens() {
        if (feline == null) {
            throw new IllegalStateException("Feline зависимость не была установлена");
        }
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        if (feline == null) {
            throw new IllegalStateException("Feline зависимость не была установлена");
        }
        return feline.getFood("Хищник");
    }
}
