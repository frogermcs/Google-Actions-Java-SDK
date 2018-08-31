package com.frogermcs.gactions.api.response;

import lombok.*;

import java.util.Map;

@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMetadata {
    public Map<String, Object> specs;
    public Status status;
}
