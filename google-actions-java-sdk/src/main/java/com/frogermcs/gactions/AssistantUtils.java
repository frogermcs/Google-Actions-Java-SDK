package com.frogermcs.gactions;

import com.frogermcs.gactions.api.request.Inputs;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;

import javax.annotation.Nullable;

/**
 * Helper methods for Google Actions API requests/responses
 */
public class AssistantUtils {
    /**
     * @param rootRequest - the {@link RootResponse} object that contains request from Google Actions
     * @return Action intent string from Google Action request.
     */
    @Nullable
    public static String getActionIntent(RootRequest rootRequest) {
        if (rootRequest.inputs != null && rootRequest.inputs.size() > 0) {
            Inputs inputs = rootRequest.inputs.get(0);
            return inputs.intent;
        }

        return null;
    }
}
