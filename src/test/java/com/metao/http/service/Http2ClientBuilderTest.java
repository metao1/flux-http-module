package com.metao.http.service;

import com.metao.http.exception.HttpRequestException;
import com.metao.http.model.http.HttpParameter;
import com.metao.http.model.response.HttpResponse;
import com.metao.http.model.http.JsonObject;
import com.metao.http.service.Http2Client;
import com.metao.http.service.Http2ClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
class Http2ClientBuilderTest {

    @Test
    void authorization() {
    }

    @Test
    void onlyGet() throws HttpRequestException {
        Http2Client clientAgent = new Http2ClientBuilder()
                .build();
        HttpResponse httpResponse = clientAgent.get("https://google.com");
        assertEquals(200, httpResponse.getStatusCode());
    }

    @Test
    void getWithParam() throws HttpRequestException {
        Http2Client clientAgent = new Http2ClientBuilder()
                .build();
        HttpParameter[] httpParameters =  new HttpParameter[]{new HttpParameter("id", "1424535306225831944")};
        HttpResponse httpResponse = clientAgent.get("https://api.twitter.com/1/statuses/oembed.json", httpParameters, null, null);
        assertEquals(200, httpResponse.getStatusCode());
        assertNotNull(httpResponse.getResponseAsString());
        log.info(httpResponse.getResponseAsString());
    }

    @Test
    void getJsonObject() throws HttpRequestException {
        Http2Client clientAgent = new Http2ClientBuilder()
                .build();
        HttpParameter[] httpParameters =  new HttpParameter[]{new HttpParameter("id", "1424535306225831944")};
        HttpResponse httpResponse = clientAgent.get("https://api.twitter.com/1/statuses/oembed.json", httpParameters , null, null);
        assertEquals(200, httpResponse.getStatusCode());
        assertNotNull(httpResponse.asJsonObject());
        JsonObject jsonObject = httpResponse.asJsonObject();
        log.info(jsonObject.toString());
    }
}