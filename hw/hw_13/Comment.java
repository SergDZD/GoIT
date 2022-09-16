package com.hw.hw_13;

public class Comment {
    private long id;
    private String name;
    private String email;
    private String body;

    public Comment(String name, String email, String body) {
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
