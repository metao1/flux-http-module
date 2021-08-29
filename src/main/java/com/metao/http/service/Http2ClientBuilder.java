package com.metao.http.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Http2ClientBuilder {

    private Authorization authorization;

    public Http2ClientBuilder() {

    }

    public Http2ClientBuilder authorization(Authorization authorization) {
        this.authorization = authorization;
        return this;
    }

    public Http2Client build() {
        return new Http2Client(this.authorization);
    }
}
