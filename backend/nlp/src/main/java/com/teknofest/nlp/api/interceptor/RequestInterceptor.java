package com.teknofest.nlp.api.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class RequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // Generate a unique Correlation-Id
        String correlationId = UUID.randomUUID().toString();

        // Add Correlation-Id header to the request
        request.getHeaders().add("Correlation-Id", correlationId);

        // Log the request details
        logRequestDetails(request, body, correlationId);

        // Continue the execution of the request
        return execution.execute(request, body);
    }

    private void logRequestDetails(HttpRequest request, byte[] body, String correlationId) throws IOException {
        System.out.println("Correlation-Id: " + correlationId);
        System.out.println("URI: " + request.getURI());
        System.out.println("HTTP Method: " + request.getMethod());
        System.out.println("Request Headers: " + request.getHeaders());
        System.out.println("Request Body: " + new String(body, "UTF-8"));
    }
}