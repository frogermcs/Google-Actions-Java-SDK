package com.frogermcs.gactions.api.response;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SpeechResponse {
    public String displayText;
    public String textToSpeech;
    public String ssml;
}
