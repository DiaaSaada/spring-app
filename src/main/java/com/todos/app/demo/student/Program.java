package com.todos.app.demo.student;

public enum Program {

    Bachelor("Bachelor", "OnCampus"),
    MasterOnCampus("Master", "OnCampus"),
    MasterRemote("Master", "Remote"),
    PhD("PhD", "OnCampus");

    private final String degree;
    private final String type;

    Program(String degree, String type) {
        this.degree = degree;
        this.type = type;
    }

    public String getDegree() {
        return degree;
    }

    public String getType() {
        return type;
    }
}
