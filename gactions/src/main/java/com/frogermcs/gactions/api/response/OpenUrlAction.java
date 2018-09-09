package com.frogermcs.gactions.api.response;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OpenUrlAction {

    public String url;
    public AndroidApp androidApp;
    public UrlTypeHint urlTypeHint;
}
