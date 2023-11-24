package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane;
    private Feline feline;

    public Lion(String sex, Feline feline) throws IllegalArgumentException {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new IllegalArgumentException("Используйте допустимые значения пола животного - самей или самка");
        }
        this.feline = feline;
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
