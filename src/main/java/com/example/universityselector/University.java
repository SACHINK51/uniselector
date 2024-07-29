package com.example.universityselector;

public class University {
    private String name;
    private String url;

    public University(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
