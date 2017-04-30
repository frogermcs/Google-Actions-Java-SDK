package com.frogermcs.gactions.api.response;

import java.util.List;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class PermissionValueSpec {
    public String opt_context;
    public List<String> permissions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionValueSpec that = (PermissionValueSpec) o;

        if (opt_context != null ? !opt_context.equals(that.opt_context) : that.opt_context != null) return false;
        return permissions != null ? permissions.equals(that.permissions) : that.permissions == null;
    }

    @Override
    public int hashCode() {
        int result = opt_context != null ? opt_context.hashCode() : 0;
        result = 31 * result + (permissions != null ? permissions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PermissionValueSpec{" +
                "opt_context='" + opt_context + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
