package com.frogermcs.gactions.api.request;

import java.util.List;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class Inputs {
    public String intent;
    public List<RawInput> rawInputs;
    public List<Argument> arguments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inputs inputs = (Inputs) o;

        if (intent != null ? !intent.equals(inputs.intent) : inputs.intent != null) return false;
        if (rawInputs != null ? !rawInputs.equals(inputs.rawInputs) : inputs.rawInputs != null) return false;
        return arguments != null ? arguments.equals(inputs.arguments) : inputs.arguments == null;
    }

    @Override
    public int hashCode() {
        int result = intent != null ? intent.hashCode() : 0;
        result = 31 * result + (rawInputs != null ? rawInputs.hashCode() : 0);
        result = 31 * result + (arguments != null ? arguments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Inputs{" +
                "intent='" + intent + '\'' +
                ", rawInputs=" + rawInputs +
                ", arguments=" + arguments +
                '}';
    }
}
