package com.frogermcs.gactions.api.response;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class InputValueSpec {
    public PermissionValueSpec permission_value_spec;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputValueSpec that = (InputValueSpec) o;

        return permission_value_spec != null ? permission_value_spec.equals(that.permission_value_spec) : that.permission_value_spec == null;
    }

    @Override
    public int hashCode() {
        return permission_value_spec != null ? permission_value_spec.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "InputValueSpec{" +
                "permission_value_spec=" + permission_value_spec +
                '}';
    }
}
