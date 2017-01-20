package com.frogermcs.gactions.api.request;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class Time {
    public int seconds;
    public int nanos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        if (seconds != time.seconds) return false;
        return nanos == time.nanos;
    }

    @Override
    public int hashCode() {
        int result = seconds;
        result = 31 * result + nanos;
        return result;
    }

    @Override
    public String toString() {
        return "Time{" +
                "seconds=" + seconds +
                ", nanos=" + nanos +
                '}';
    }
}
