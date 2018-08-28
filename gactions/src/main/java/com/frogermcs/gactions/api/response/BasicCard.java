package com.frogermcs.gactions.api.response;

import lombok.*;

import java.util.List;

@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BasicCard {
    public String title;
    public String subtitle;
    public String formattedText;
    public Image image;
    public List<Button> buttons;
    public ImageDisplayOptions imageDisplayOptions;
}
