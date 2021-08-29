package com.metao.http.service;

import com.metao.http.async.Mono;
import com.metao.http.exception.HttpRequestException;
import com.metao.http.model.request.HttpRequest;
import com.metao.http.model.response.HttpResponse;

import java.util.function.Function;

public class AsyncHttpClient extends AsyncHttpClientBase {

    @Override
    public final Mono<HttpResponse> asyncHandleRequest(HttpRequest req) throws HttpRequestException {
        return Mono.just(handleRequest(req)).map(Function.identity());
    }
}
