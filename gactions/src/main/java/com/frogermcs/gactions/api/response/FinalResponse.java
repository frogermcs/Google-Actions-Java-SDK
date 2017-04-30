package com.frogermcs.gactions.api.response;

/**
 * Created by froger_mcs on 18/01/2017.
 */
public class FinalResponse {
    public SpeechResponse speech_response;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinalResponse that = (FinalResponse) o;

        return speech_response != null ? speech_response.equals(that.speech_response) : that.speech_response == null;
    }

    @Override
    public int hashCode() {
        return speech_response != null ? speech_response.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FinalResponse{" +
                "speech_response=" + speech_response +
                '}';
    }
}
