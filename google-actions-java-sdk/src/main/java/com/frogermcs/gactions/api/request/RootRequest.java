package com.frogermcs.gactions.api.request;

import java.util.List;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class RootRequest {
    public User user;
    public Device device;
    public Conversation conversation;
    public List<Inputs> inputs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RootRequest that = (RootRequest) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (device != null ? !device.equals(that.device) : that.device != null) return false;
        if (conversation != null ? !conversation.equals(that.conversation) : that.conversation != null) return false;
        return inputs != null ? inputs.equals(that.inputs) : that.inputs == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (device != null ? device.hashCode() : 0);
        result = 31 * result + (conversation != null ? conversation.hashCode() : 0);
        result = 31 * result + (inputs != null ? inputs.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RootRequest{" +
                "user=" + user +
                ", device=" + device +
                ", conversation=" + conversation +
                ", inputs=" + inputs +
                '}';
    }
}
