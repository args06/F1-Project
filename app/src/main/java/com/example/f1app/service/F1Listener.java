package com.example.f1app.service;

public interface F1Listener<T> {
    void onSuccess(T items);
    void onFailed(String msg);
}
