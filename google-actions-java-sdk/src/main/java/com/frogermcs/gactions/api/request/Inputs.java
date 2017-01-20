package com.frogermcs.gactions.api.request;

import java.util.List;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class Inputs {
    public String intent;
    public List<RawInput> raw_inputs;
    public List<Argument> arguments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inputs inputs = (Inputs) o;

        if (intent != null ? !intent.equals(inputs.intent) : inputs.intent != null) return false;
        if (raw_inputs != null ? !raw_inputs.equals(inputs.raw_inputs) : inputs.raw_inputs != null) return false;
        return arguments != null ? arguments.equals(inputs.arguments) : inputs.arguments == null;
    }

    @Override
    public int hashCode() {
        int result = intent != null ? intent.hashCode() : 0;
        result = 31 * result + (raw_inputs != null ? raw_inputs.hashCode() : 0);
        result = 31 * result + (arguments != null ? arguments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Inputs{" +
                "intent='" + intent + '\'' +
                ", raw_inputs=" + raw_inputs +
                ", arguments=" + arguments +
                '}';
    }
}
