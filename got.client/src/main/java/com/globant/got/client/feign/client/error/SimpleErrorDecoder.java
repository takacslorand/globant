package com.globant.got.client.feign.client.error;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

@Slf4j
public class SimpleErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        try {
            switch (response.status()) {
                case 404:
                    return new FeignClientException("Item not found or not exists");
                case 403:
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                    ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
                    return new FeignClientException(Optional.of(errorResponse.getMessage()).orElse("No access"));
            }
        } catch (IOException e) {
            log.error("IO exception  error decoder, e");
            return new FeignClientException("Failed to understand the error received/IO error.");
        }

        return errorDecoder.decode(s, response);
    }
}