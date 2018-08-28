package com.frogermcs.gactions.api.response;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VersionFilter {
    public int minVersion;
    public int maxVersion;
}
