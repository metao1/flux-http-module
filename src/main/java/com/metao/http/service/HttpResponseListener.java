package com.metao.http.service;

import com.metao.http.model.response.HttpEvent;

public interface HttpResponseListener {
    void onResponse(HttpEvent resEvent);
    void onException(Throwable thr);
}
