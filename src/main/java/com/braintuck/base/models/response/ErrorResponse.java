package com.braintuck.base.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse extends Throwable {
    private String error;
    private String description;
    private String error_description;
}
