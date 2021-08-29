package com.metao.http.async;

import java.util.function.Function;

public interface MonoProcessorListener<T> {
    Mono<T> onErrorMap(Function<? extends Throwable, ? extends Throwable> errorFun);
}
