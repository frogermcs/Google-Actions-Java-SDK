package com.frogermcs.gactions.api.request;

/**
 * Created by froger_mcs on 17/01/2017.
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Argument argument = (Argument) o;

        if (name != null ? !name.equals(argument.name) : argument.name != null) return false;
        if (raw_text != null ? !raw_text.equals(argument.raw_text) : argument.raw_text != null) return false;
        if (int_value != null ? !int_value.equals(argument.int_value) : argument.int_value != null) return false;
        if (bool_value != null ? !bool_value.equals(argument.bool_value) : argument.bool_value != null) return false;
        if (text_value != null ? !text_value.equals(argument.text_value) : argument.text_value != null) return false;
        if (date_value != null ? !date_value.equals(argument.date_value) : argument.date_value != null) return false;
        if (time_value != null ? !time_value.equals(argument.time_value) : argument.time_value != null) return false;
        if (location_value != null ? !location_value.equals(argument.location_value) : argument.location_value != null)
            return false;
        return formatted_address != null ? formatted_address.equals(argument.formatted_address) : argument.formatted_address == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (raw_text != null ? raw_text.hashCode() : 0);
        result = 31 * result + (int_value != null ? int_value.hashCode() : 0);
        result = 31 * result + (bool_value != null ? bool_value.hashCode() : 0);
        result = 31 * result + (text_value != null ? text_value.hashCode() : 0);
        result = 31 * result + (date_value != null ? date_value.hashCode() : 0);
        result = 31 * result + (time_value != null ? time_value.hashCode() : 0);
        result = 31 * result + (location_value != null ? location_value.hashCode() : 0);
        result = 31 * result + (formatted_address != null ? formatted_address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Argument{" +
                "name='" + name + '\'' +
                ", raw_text='" + raw_text + '\'' +
                ", int_value='" + int_value + '\'' +
                ", bool_value='" + bool_value + '\'' +
                ", text_value='" + text_value + '\'' +
                ", date_value='" + date_value + '\'' +
                ", time_value='" + time_value + '\'' +
                ", location_value=" + location_value +
                ", formatted_address='" + formatted_address + '\'' +
                '}';
    }
}
