package com.frogermcs.gactions.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by froger_mcs on 17/01/2017.
 */
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class ExpectedIntent {
    public String intent;
    public InputValueSpec inputValueSpec;

    public ExpectedIntent(String intent) {
        this.intent = intent;
    }
}
