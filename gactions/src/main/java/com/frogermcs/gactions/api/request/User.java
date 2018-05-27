package com.frogermcs.gactions.api.request;

import lombok.*;

import java.util.Date;
import java.util.Locale;

/**
 * Created by froger_mcs on 17/01/2017.
 */

@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    public String userId;
    public UserProfile profile;
    public String access_token;
    public Locale locale;
    public Date lastSeen;
}
