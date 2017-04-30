package com.frogermcs.gactions.api.request;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class User {
    public String user_id;
    public UserProfile profile;
    public String access_token;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (user_id != null ? !user_id.equals(user.user_id) : user.user_id != null) return false;
        if (profile != null ? !profile.equals(user.profile) : user.profile != null) return false;
        return access_token != null ? access_token.equals(user.access_token) : user.access_token == null;
    }

    @Override
    public int hashCode() {
        int result = user_id != null ? user_id.hashCode() : 0;
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (access_token != null ? access_token.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", profile=" + profile +
                ", access_token='" + access_token + '\'' +
                '}';
    }
}
