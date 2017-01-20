package com.frogermcs.gactions.api.response;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class ExpectedIntent {
    public String intent;
    public InputValueSpec input_value_spec;

    public ExpectedIntent(String intent) {
        this.intent = intent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpectedIntent that = (ExpectedIntent) o;

        if (intent != null ? !intent.equals(that.intent) : that.intent != null) return false;
        return input_value_spec != null ? input_value_spec.equals(that.input_value_spec) : that.input_value_spec == null;
    }

    @Override
    public int hashCode() {
        int result = intent != null ? intent.hashCode() : 0;
        result = 31 * result + (input_value_spec != null ? input_value_spec.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExpectedIntent{" +
                "intent='" + intent + '\'' +
                ", input_value_spec=" + input_value_spec +
                '}';
    }
}
