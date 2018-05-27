package com.frogermcs.gactions.api.response;

import lombok.*;

import java.util.List;

@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InputPrompt {
    public RichInitialPrompt richInitialPrompt;
    public List<SpeechResponse> initialPrompts;
    public List<SpeechResponse> noInputPrompts;
}
