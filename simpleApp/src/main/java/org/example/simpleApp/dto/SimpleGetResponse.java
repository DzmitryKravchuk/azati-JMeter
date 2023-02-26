package org.example.simpleApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SimpleGetResponse {
    private Long id;
    private Integer intValue;
}
