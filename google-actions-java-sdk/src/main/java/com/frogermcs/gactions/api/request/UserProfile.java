package com.frogermcs.gactions.api.request;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class UserProfile {
    public String given_name;
    public String family_name;
    public String display_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserProfile userProfile = (UserProfile) o;

        if (given_name != null ? !given_name.equals(userProfile.given_name) : userProfile.given_name != null) return false;
        if (family_name != null ? !family_name.equals(userProfile.family_name) : userProfile.family_name != null)
            return false;
        return display_name != null ? display_name.equals(userProfile.display_name) : userProfile.display_name == null;
    }

    @Override
    public int hashCode() {
        int result = given_name != null ? given_name.hashCode() : 0;
        result = 31 * result + (family_name != null ? family_name.hashCode() : 0);
        result = 31 * result + (display_name != null ? display_name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "given_name='" + given_name + '\'' +
                ", family_name='" + family_name + '\'' +
                ", display_name='" + display_name + '\'' +
                '}';
    }
}
