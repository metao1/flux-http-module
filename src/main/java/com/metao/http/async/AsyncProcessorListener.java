package com.metao.http.async;

import java.util.function.Function;

public interface AsyncProcessorListener<T> {
    Async<T> onErrorMap(Function<? extends Throwable, ? extends Throwable> errorFun);
}
