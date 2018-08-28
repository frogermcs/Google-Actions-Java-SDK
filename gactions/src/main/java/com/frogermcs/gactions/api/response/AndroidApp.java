package com.frogermcs.gactions.api.response;

import lombok.*;

import java.util.List;

@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AndroidApp {
    public String packageName;
    public List<VersionFilter> versions;
}
