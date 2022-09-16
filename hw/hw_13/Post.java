package com.hw.hw_13;

public class Post {
    private long id;
    String title;
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
