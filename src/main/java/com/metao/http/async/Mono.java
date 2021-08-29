package com.metao.http.async;

import java.util.function.Function;

public abstract class Mono<T> implements MonoProcessorListener<T> {

    public static <T> Mono<T> just(T... t) {
        return assembly(new MonoJust<>());
    }

    public final <R> Mono<R> map(Function<T, R> mapperFunction) {

    }

    protected static <T> Mono<T> assembly(Mono<T> data) {
        return data;
    }
}
