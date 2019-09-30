package com.example.demo.entity;

public class JsonResponse {
    private int status;
    private String message;
    private Object metaData;

    public JsonResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public JsonResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public JsonResponse setMetaData(Object metaData) {
        this.metaData = metaData;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getMetaData() {
        return metaData;
    }
}
