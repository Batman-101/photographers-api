package com.excel.studio.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
@Data
public class ErrorModel {
    private Integer errorCode;
    private String message;
    private String details;

}
