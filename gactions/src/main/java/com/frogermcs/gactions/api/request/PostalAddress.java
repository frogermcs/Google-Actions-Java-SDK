package com.frogermcs.gactions.api.request;

import java.util.List;

/**
 * https://developers.google.com/actions/reference/rest/Shared.Types/PostalAddress
 */
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostalAddress {
    public int revision;
    public String regionCode;
    public String languageCode;
    public String postalCode;
    public String sortingCode;
    public String administrativeArea;
    public String locality;
    public String sublocality;
    public List<String> addressLines;
    public List<String> recipients;
    public String organization;
}