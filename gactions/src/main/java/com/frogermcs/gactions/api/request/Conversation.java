package com.frogermcs.gactions.api.request;

import lombok.*;

/**
 * Created by froger_mcs on 17/01/2017.
 */
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Conversation {
    public String conversationId;
    public ConversationType type;
    public String conversationToken;
}
