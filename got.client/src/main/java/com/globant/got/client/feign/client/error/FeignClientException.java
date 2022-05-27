package com.globant.got.client.feign.client.error;

public class FeignClientException extends RuntimeException {
    public FeignClientException(String message) {
        super(message);
    }
}