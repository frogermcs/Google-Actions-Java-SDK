package com.frogermcs.gactions.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InputValueData {
    @JsonProperty("@type")
    private String type;
    @JsonProperty
    private String optContext;
    @JsonProperty
    private List<String> permissions;
}

