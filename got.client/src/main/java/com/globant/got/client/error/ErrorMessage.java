package com.globant.got.client.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private LocalDate timestamp;
    private String message;
    private String description;
}
