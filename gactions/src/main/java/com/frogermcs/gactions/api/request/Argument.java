package com.frogermcs.gactions.api.request;

import lombok.*;

@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Argument {
    public String name;
    public String raw_text;
    public String int_value;
    public String bool_value;
    public String text_value;
    public String date_value;
    public String time_value;
    public Location location_value;
    public String formatted_address;
}
