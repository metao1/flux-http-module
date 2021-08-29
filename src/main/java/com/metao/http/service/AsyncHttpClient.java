package com.metao.http.service;

import com.metao.http.async.Async;
import com.metao.http.exception.HttpRequestException;
import com.metao.http.model.request.HttpRequest;
import com.metao.http.model.response.HttpResponse;
import reactor.core.publisher.Mono;

public class AsyncHttpClient extends AsyncHttpClientBase {

    @Override
    public final Mono<HttpResponse> asyncHandleRequest(HttpRequest req) throws HttpRequestException {
        return Async.just(handleRequest(req));
    }
}
