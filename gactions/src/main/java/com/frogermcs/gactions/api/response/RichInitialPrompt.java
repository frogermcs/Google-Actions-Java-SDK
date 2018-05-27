package com.frogermcs.gactions.api.response;

import lombok.*;

import java.util.List;

@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RichInitialPrompt {
    public List<RichInitialPromptItems> items;
    public List<SuggestionResponse> suggestions;
}
