package com.example.electronicsstore.exception;

public class ErrorResponse {
    private String title;
    private String detail;

    public ErrorResponse(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }
}

