package com.frogermcs.gactions.api.request;

import lombok.*;

import javax.annotation.Nullable;

/**
 * Created by froger_mcs on 17/01/2017.
 */
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Nullable
    public Coordinates coordinates;
    @Nullable
    public String formatted_address;
    public String city;
    public String zip_code;
}
