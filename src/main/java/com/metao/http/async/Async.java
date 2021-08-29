package com.metao.http.async;

import reactor.core.publisher.Mono;

public abstract class Async<T> implements AsyncProcessorListener<T> {

    public static <T> Mono<T> just(T t) {
        return assembly(t);
    }

    protected static <T> Mono<T> assembly(T data) {
        AsyncJust<T> just = AsyncJust.data(data);
        return just.getData();
    }

}
