package com.dylan.bean;

import java.io.Serializable;

public class Cat implements Cloneable,Serializable {

    private String name = "miaomiao";
    private int age = 2;

    MainPerson mainPerson;

    public MainPerson getMainPerson() {
        return mainPerson;
    }

    public void setMainPerson(MainPerson mainPerson) {
        this.mainPerson = mainPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Cat clone() {

        try {
            return (Cat)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
