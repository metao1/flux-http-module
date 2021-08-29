package com.metao.http.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpClientBuilder {

    private Authorization authorization;

    public HttpClientBuilder() {

    }

    public HttpClientBuilder authorization(Authorization authorization) {
        this.authorization = authorization;
        return this;
    }

    public Http2Client build() {
        return new Http2Client(this.authorization);
    }
}
