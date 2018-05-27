package com.frogermcs.gactions.api.response;

import lombok.*;

import java.util.List;

@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PermissionValueSpec {
    public String optContext;
    public List<String> permissions;
}
