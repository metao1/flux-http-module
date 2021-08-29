package com.metao.http.service;

import com.metao.http.exception.HttpRequestException;
import com.metao.http.model.response.HttpResponse;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

class AsyncHttpClientBuilderTest {

    @Test
    void build() throws HttpRequestException {
        AsyncHttpClient httpClient = AsyncHttpClientBuilder.build();

        HttpResponse httpResponse = httpClient.asyncGet("https://google.com")
                .block();

        assertNotNull(httpResponse);

        assertEquals(200, httpResponse.getStatusCode());
    }

    @Test
    void convertMonoToFuture() throws HttpRequestException, ExecutionException, InterruptedException, TimeoutException {
        AsyncHttpClient httpClient = AsyncHttpClientBuilder.build();

        CompletableFuture<HttpResponse> future = httpClient.asyncGet("https://google.com").toFuture();
        HttpResponse httpResponse = future.get(200, TimeUnit.SECONDS);
        assertNotNull(httpResponse);

        assertEquals(200, httpResponse.getStatusCode());
    }
}