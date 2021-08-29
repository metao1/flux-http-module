package com.metao.http.service;

import com.metao.http.async.Async;
import com.metao.http.async.MonoClient;
import com.metao.http.exception.HttpRequestException;
import com.metao.http.model.http.HttpParameter;
import com.metao.http.model.request.HttpRequest;
import com.metao.http.model.request.RequestMethod;
import com.metao.http.model.response.HttpEvent;
import com.metao.http.model.response.HttpResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public abstract class AsyncHttpClientBase extends Http2Client implements MonoClient {

    public AsyncHttpClientBase() {
        super();
    }

    public AsyncHttpClientBase(Authorization authorization) {
        super(authorization);
    }

    @Override
    public Mono<HttpResponse> asyncGet(String url) throws HttpRequestException {
        return asyncRequest(new HttpRequest(url, RequestMethod.GET, null, getRequestHeaders(), getAuthorization()));
    }

    @Override
    public Mono<HttpResponse> asyncGet(String url, HttpParameter[] params, Authorization authorization, HttpEventListener listener) throws HttpRequestException {
        return asyncRequest(new HttpRequest(url, RequestMethod.GET, null, getRequestHeaders(), getAuthorization()), listener);
    }

    @Override
    public Mono<HttpResponse> asyncRequest(final HttpRequest req, final HttpEventListener httpResponseListener) throws HttpRequestException {
        if (httpResponseListener != null) {
            httpResponseListener.onRequest(HttpEvent.createRequestEvent(req));
        }
        return asyncRequest(req).onErrorMap(error -> {
            if (httpResponseListener != null) {
                httpResponseListener.onException(error);
            }
            return error;
        });
    }

    @Override
    public Mono<HttpResponse> asyncPost(String url) throws HttpRequestException {
        return asyncRequest(new HttpRequest(url, RequestMethod.POST, null, getRequestHeaders(), getAuthorization()));
    }

    @Override
    public Mono<HttpResponse> asyncPost(String url, HttpParameter[] params, Authorization authorization, HttpEventListener listener) throws HttpRequestException {
        return asyncRequest(new HttpRequest(url, RequestMethod.POST, params, getRequestHeaders(), getAuthorization()), listener);
    }

    @Override
    public Mono<HttpResponse> asyncRequest(HttpRequest req) throws HttpRequestException {
        return asyncHandleRequest(req);
    }

    public abstract Mono<HttpResponse> asyncHandleRequest(HttpRequest request) throws HttpRequestException;
}