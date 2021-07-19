package com.company;

import java.io.Serializable;

public class StudentSerializable implements Serializable {
    private String name;
    private int id;
    private String department;

    public StudentSerializable(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    @Override
    public String toString() {
        return "StudentSerializable{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", department='" + department + '\'' +
                '}';
    }
}
