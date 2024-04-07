package com.kopiyama.model;

public class Novelis extends Person{

    public Novelis() {
    }
    public Novelis(String name) {
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
        return "Novelis : " + '\n' +
                super.toString() + '\n'
                ;
    }
}
