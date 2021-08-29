package com.metao.http.async;

import reactor.core.publisher.Mono;

import java.util.function.Function;

final class AsyncJust<T> extends Async<T> {

    private final Mono<T> data;

    private AsyncJust(Mono<T> t) {
        this.data = t;
    }

    public static <T> AsyncJust<T> data(T t) {
        return new AsyncJust<>(Mono.just(t));
    }

    public Mono<T> getData() {
        return data;
    }

    @Override
    public Async<T> onErrorMap(Function<? extends Throwable, ? extends Throwable> errorFun) {
        return null;
    }
}
