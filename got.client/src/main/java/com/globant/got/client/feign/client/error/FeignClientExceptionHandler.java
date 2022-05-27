package com.globant.got.client.feign.client.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class FeignClientExceptionHandler implements FeignHttpExceptionHandler {
    @Override
    public Exception handle(Response response) {

        if (response.status() == HttpStatus.BAD_REQUEST.value()) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
                return new FeignClientException(errorResponse.getMessage());
            } catch (IOException e) {
                log.error("Error deserializing feign error", e);
                throw new RuntimeException("Error while deserializing the response body");
            }
        }
        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            return new FeignClientException("Item not found or not exists");
        }
        return new FeignClientException( String.format("Unhandled Feign error status %d body %s", response.status(), response.body()));
    }

    private String readResponse(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        for (int length; (length = inputStream.read(buffer)) != -1; ) {
            result.write(buffer, 0, length);
        }
        return result.toString(StandardCharsets.UTF_8.name());
    }
}