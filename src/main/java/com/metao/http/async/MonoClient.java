package com.metao.http.async;

import com.metao.http.exception.HttpRequestException;
import com.metao.http.model.http.HttpParameter;
import com.metao.http.model.request.HttpRequest;
import com.metao.http.model.response.HttpResponse;
import com.metao.http.service.Authorization;
import com.metao.http.service.HttpEventListener;
import reactor.core.publisher.Mono;

public interface MonoClient {

    Mono<HttpResponse> asyncRequest(HttpRequest req, HttpEventListener httpResponseListener) throws HttpRequestException;

    Mono<HttpResponse> asyncRequest(HttpRequest req) throws HttpRequestException;

    Mono<HttpResponse> asyncGet(String url) throws HttpRequestException;

    Mono<HttpResponse> asyncGet(String url, HttpParameter[] params, Authorization authorization, HttpEventListener listener) throws HttpRequestException;

    Mono<HttpResponse> asyncPost(String url) throws HttpRequestException;

    Mono<HttpResponse> asyncPost(String url, HttpParameter[] params, Authorization authorization, HttpEventListener listener) throws HttpRequestException;
}
