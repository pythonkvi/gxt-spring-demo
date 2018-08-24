package com.example.gxtspringdemo.shared;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class DemoDTO implements Serializable {
    private final String msg;

    public DemoDTO() {
        msg = null;
    }

    @JsonCreator
    public DemoDTO(@JsonProperty("msg") String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
