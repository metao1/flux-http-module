package com.metao.http.service;

import com.metao.http.model.response.HttpEvent;

public interface HttpRequestListener {
    void onRequest(HttpEvent resEvent);
}
