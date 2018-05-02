package com.frogermcs.gactions.api.request;

import java.util.Locale;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class User {
    public String userId;
    public UserProfile profile;
    public String access_token;
    public Locale locale;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (profile != null ? !profile.equals(user.profile) : user.profile != null) return false;
        if (locale  != null ? !locale.equals(user.locale)   : user.locale  != null) return false;
        return access_token != null ? access_token.equals(user.access_token) : user.access_token == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        result = 31 * result + (access_token != null ? access_token.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", profile=" + profile +
                ", access_token='" + access_token + '\'' +
                ", locale=" + locale +
                '}';
    }
}
