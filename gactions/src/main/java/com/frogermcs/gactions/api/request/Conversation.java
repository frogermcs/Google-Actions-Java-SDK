package com.frogermcs.gactions.api.request;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class Conversation {
    public String conversation_id;
    public ConversationType type;
    public String conversation_token;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conversation that = (Conversation) o;

        if (conversation_id != null ? !conversation_id.equals(that.conversation_id) : that.conversation_id != null)
            return false;
        if (type != that.type) return false;
        return conversation_token != null ? conversation_token.equals(that.conversation_token) : that.conversation_token == null;
    }

    @Override
    public int hashCode() {
        int result = conversation_id != null ? conversation_id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (conversation_token != null ? conversation_token.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "conversation_id='" + conversation_id + '\'' +
                ", type=" + type +
                ", conversation_token='" + conversation_token + '\'' +
                '}';
    }
}
