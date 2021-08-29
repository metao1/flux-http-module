package com.metao.http.async;

import kotlin.NotImplementedError;

import java.util.function.Function;

public class MonoJust<T> extends Mono<T> {

    public static <T> MonoJust<T> data(T[] t) {
        throw new NotImplementedError("");
    }

    @Override
    public Mono<T> onErrorMap(Function<? extends Throwable, ? extends Throwable> errorFun) {
        return null;
    }
}
