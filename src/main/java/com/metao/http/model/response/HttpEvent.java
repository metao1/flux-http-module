package com.metao.http.model.response;

import com.metao.http.exception.HttpRequestException;
import com.metao.http.model.request.HttpRequest;

public class HttpEvent {
    private HttpRequest req;
    private HttpResponse res;
    private HttpRequestException exception;

    private HttpEvent(HttpRequest req) {
        this.req = req;
    }

    public HttpEvent(HttpResponse res) {
        this.res = res;
    }

    private HttpEvent(HttpRequest req, HttpResponse res) {
        this.req = req;
        this.res = res;
    }

    public HttpEvent(HttpRequest req, HttpResponse res, HttpRequestException exception) {
        this(req, res);
        this.exception = exception;
    }

    public static HttpEvent createRequestEvent(HttpRequest req) {
        return new HttpEvent(req);
    }

    public static HttpEvent createResponseEvent(HttpResponse res) {
        return new HttpEvent(null, res);
    }

    public static HttpEvent createRequestResponseEvent(HttpRequest req, HttpResponse res) {
        return new HttpEvent(req, res);
    }

    public static HttpEvent createRequestResponseEvent(HttpRequest req, HttpResponse res, HttpRequestException e) {
        return new HttpEvent(req, res, e);
    }

    public HttpRequest getReq() {
        return req;
    }

    public HttpResponse getRes() {
        return res;
    }

    public HttpRequestException getException() {
        return exception;
    }

    boolean ranExceptionally() {
        return exception != null;
    }
}
