package com.frogermcs.gactions.api.response;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class SpeechResponse {
    public String text_to_speech;
    public String ssml;

    public SpeechResponse(String text_to_speech, String ssml) {
        this.text_to_speech = text_to_speech;
        this.ssml = ssml;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpeechResponse that = (SpeechResponse) o;

        if (text_to_speech != null ? !text_to_speech.equals(that.text_to_speech) : that.text_to_speech != null)
            return false;
        return ssml != null ? ssml.equals(that.ssml) : that.ssml == null;
    }

    @Override
    public int hashCode() {
        int result = text_to_speech != null ? text_to_speech.hashCode() : 0;
        result = 31 * result + (ssml != null ? ssml.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SpeechResponse{" +
                "text_to_speech='" + text_to_speech + '\'' +
                ", ssml='" + ssml + '\'' +
                '}';
    }
}
