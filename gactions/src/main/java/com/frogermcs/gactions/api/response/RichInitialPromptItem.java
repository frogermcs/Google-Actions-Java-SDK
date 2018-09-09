package com.frogermcs.gactions.api.response;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RichInitialPromptItem {
    public SpeechResponse simpleResponse;
    public BasicCard basicCard;
}
