package com.apudasgupta.api.gateway.zuul.config;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.exception.HystrixTimeoutException;

/**
 * @author Apu Das Gupta
 *
 */

@Component
class GatewayServiceFallback implements FallbackProvider {

    private static final String DEFAULT_MESSAGE = "Service not available.";

    @Override
    public String getRoute() {
        return "*"; // or return null;
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        if (cause instanceof HystrixTimeoutException) {
            return new GatewayClientResponse(HttpStatus.GATEWAY_TIMEOUT, DEFAULT_MESSAGE);
        } else {
            return new GatewayClientResponse(HttpStatus.INTERNAL_SERVER_ERROR, DEFAULT_MESSAGE);
        }
    }

}

