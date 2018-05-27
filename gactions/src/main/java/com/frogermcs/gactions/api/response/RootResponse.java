package com.frogermcs.gactions.api.response;

import lombok.*;

import java.util.List;

/**
 * Created by froger_mcs on 17/01/2017.
 */
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RootResponse {
    public String conversationToken;
    public boolean expectUserResponse;
    public List<ExpectedInputs> expectedInputs;
    public FinalResponse finalResponse;
}
