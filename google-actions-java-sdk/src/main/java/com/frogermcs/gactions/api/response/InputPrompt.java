package com.frogermcs.gactions.api.response;

import java.util.List;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class InputPrompt {
    public List<SpeechResponse> initial_prompts;
    public List<SpeechResponse> no_input_prompts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputPrompt that = (InputPrompt) o;

        if (initial_prompts != null ? !initial_prompts.equals(that.initial_prompts) : that.initial_prompts != null)
            return false;
        return no_input_prompts != null ? no_input_prompts.equals(that.no_input_prompts) : that.no_input_prompts == null;
    }

    @Override
    public int hashCode() {
        int result = initial_prompts != null ? initial_prompts.hashCode() : 0;
        result = 31 * result + (no_input_prompts != null ? no_input_prompts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InputPrompt{" +
                "initial_prompts=" + initial_prompts +
                ", no_input_prompts=" + no_input_prompts +
                '}';
    }
}
