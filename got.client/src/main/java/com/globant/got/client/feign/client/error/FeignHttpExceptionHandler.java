package com.globant.got.client.feign.client.error;

import feign.Response;

public interface FeignHttpExceptionHandler {
    Exception handle(Response response);
}