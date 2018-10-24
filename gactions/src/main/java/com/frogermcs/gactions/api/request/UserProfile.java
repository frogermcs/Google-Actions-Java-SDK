package com.frogermcs.gactions.api.request;

/**
 * Created by froger_mcs on 17/01/2017.
 */
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
    public String givenName;
    public String familyName;
    public String displayName;
    public String email;
}
