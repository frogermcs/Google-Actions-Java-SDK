package com.frogermcs.gactions.api.request;
import lombok.*;
/**
 * Created by froger_mcs on 17/01/2017.
 *
 * https://developers.google.com/actions/reference/rest/Shared.Types/Location
 *
 */
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    public Coordinates coordinates;
    public String formattedAddress;
    public String city;
    public String zipCode;
    public PostalAddress postalAddress;
    public String name;
    public String phoneNumber;
    public String notes;
    public String placeId;
}
