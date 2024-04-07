package com.kopiyama.model;

public class Mangaka extends Person{

    public Mangaka() {
    }
    public Mangaka(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String toString() {
        return "Mangaka : " + '\n' +
                super.toString() + '\n'
                ;
    }
}
