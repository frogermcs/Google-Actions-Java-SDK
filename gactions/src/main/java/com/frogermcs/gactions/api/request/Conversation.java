package com.frogermcs.gactions.api.request;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class Conversation {
    public String conversationId;
    public ConversationType type;
    public String conversation_token;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conversation that = (Conversation) o;

        if (conversationId != null ? !conversationId.equals(that.conversationId) : that.conversationId != null)
            return false;
        if (type != that.type) return false;
        return conversation_token != null ? conversation_token.equals(that.conversation_token) : that.conversation_token == null;
    }

    @Override
    public int hashCode() {
        int result = conversationId != null ? conversationId.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (conversation_token != null ? conversation_token.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "conversationId='" + conversationId + '\'' +
                ", type=" + type +
                ", conversation_token='" + conversation_token + '\'' +
                '}';
    }
}
