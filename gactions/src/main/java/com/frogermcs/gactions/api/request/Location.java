package com.frogermcs.gactions.api.request;

import javax.annotation.Nullable;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class Location {
    @Nullable
    public Coordinates coordinates;
    @Nullable
    public String formatted_address;
    public String city;
    public String zip_code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (coordinates != null ? !coordinates.equals(location.coordinates) : location.coordinates != null)
            return false;
        if (formatted_address != null ? !formatted_address.equals(location.formatted_address) : location.formatted_address != null)
            return false;
        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        return zip_code != null ? zip_code.equals(location.zip_code) : location.zip_code == null;
    }

    @Override
    public int hashCode() {
        int result = coordinates != null ? coordinates.hashCode() : 0;
        result = 31 * result + (formatted_address != null ? formatted_address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zip_code != null ? zip_code.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "coordinates=" + coordinates +
                ", formatted_address='" + formatted_address + '\'' +
                ", city='" + city + '\'' +
                ", zip_code='" + zip_code + '\'' +
                '}';
    }
}
