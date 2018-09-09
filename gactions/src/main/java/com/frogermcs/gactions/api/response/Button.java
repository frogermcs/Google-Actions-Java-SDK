package com.frogermcs.gactions.api.response;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Button {
    public String title;
    public OpenUrlAction openUrlAction;
}
