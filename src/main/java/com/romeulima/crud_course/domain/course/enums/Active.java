package com.romeulima.crud_course.domain.course.enums;

public enum Active {

    ENABLED("enabled"),
    DISABLED("disabled");

    private String state;

    Active (String state) {
        this.state = state.toLowerCase();
    }

    public String getState(){
        return this.state;
    }
}
