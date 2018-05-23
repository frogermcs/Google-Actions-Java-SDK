package com.frogermcs.gactions.api.request;

import lombok.*;

import java.util.List;

/**
 * Created by froger_mcs on 17/01/2017.
 */
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Inputs {
    public String intent;
    public List<RawInput> rawInputs;
    public List<Argument> arguments;
}
