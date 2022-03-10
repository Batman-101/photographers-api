package com.excel.studio.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
public class Photographer {
    private String id;
    private String name;
    private Contact contact;
    private List<String> eventType;
    private String avatar;
    private String address;
}
