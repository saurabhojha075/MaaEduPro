package com.example.maaedupro.controllers.network.models.response;

import com.google.gson.annotations.SerializedName;

public class AbstractResponse {

    private int statusCode;
    private String message;
    private Object error;
    private int offset;
    private int count;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    private int totalCount;
    @SerializedName("next")
    private boolean hasNext;


    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Object getError() {
        return error;
    }


    public int getOffset() {
        return offset;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}