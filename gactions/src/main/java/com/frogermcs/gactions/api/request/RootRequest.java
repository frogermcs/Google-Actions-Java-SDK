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
public class RootRequest {
    public User user;
    public Device device;
    public Conversation conversation;
    public List<Inputs> inputs;
}
