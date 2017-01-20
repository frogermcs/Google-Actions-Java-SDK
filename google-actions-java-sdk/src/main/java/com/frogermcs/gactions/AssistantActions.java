package com.frogermcs.gactions;

import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.api.ActionsConfig;
import com.frogermcs.gactions.api.request.Inputs;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by froger_mcs on 18/01/2017.
 */
public class AssistantActions {
    private ResponseHandler responseHandler;
    private Map<String, RequestHandler.Factory> requestHandlersFactories;

    AssistantActions() {

    }

    public void handleRequest(RootRequest rootRequest) {
        responseHandler.onPrepareContentType(ActionsConfig.HTTP_CONTENT_TYPE_JSON);
        responseHandler.onPrepareResponseHeaders(ActionsConfig.RESPONSE_HEADERS);

        String actionIntent = getActionIntent(rootRequest);
        if (actionIntent != null && requestHandlersFactories.containsKey(actionIntent)) {
            RequestHandler requestHandler = requestHandlersFactories.get(actionIntent).create();
            RootResponse rootResponse = requestHandler.onRequest(rootRequest);
            responseHandler.onResponse(rootResponse);
        } else {
            responseHandler.onResponse(ResponseBuilder.tellResponse(ActionsConfig.ERROR_MESSAGE));
        }
    }

    @Nullable
    private String getActionIntent(RootRequest rootRequest) {
        if (rootRequest.inputs != null && rootRequest.inputs.size() > 0) {
            Inputs inputs = rootRequest.inputs.get(0);
            return inputs.intent;
        }

        return null;
    }

    public static class Builder {
        private ResponseHandler responseHandler;

        private final Map<String, RequestHandler.Factory> requestHandlersFactories = new HashMap<>();

        public Builder(ResponseHandler responseHandler) {
            this.responseHandler = responseHandler;
        }

        public Builder addRequestHandlerFactory(String actionIntent, RequestHandler.Factory factory) {
            this.requestHandlersFactories.put(actionIntent, factory);
            return this;
        }

        public AssistantActions build() {
            AssistantActions assistantActions = new AssistantActions();
            assistantActions.responseHandler = responseHandler;
            assistantActions.requestHandlersFactories = requestHandlersFactories;
            return assistantActions;
        }
    }
}
