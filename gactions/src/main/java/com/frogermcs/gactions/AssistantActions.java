package com.frogermcs.gactions;

import com.frogermcs.gactions.api.ActionsConfig;
import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code ActionsServlet} is the class that handles conversation API from Google Assistant.
 * Requests ({@link com.frogermcs.gactions.api.request.RootRequest} are passed to {@link com.frogermcs.gactions.api.RequestHandler}
 * based on action intents mapping.
 */
public class AssistantActions {
    private final ResponseHandler responseHandler;
    private final Map<String, RequestHandler.Factory> requestHandlersFactories;

    AssistantActions(ResponseHandler responseHandler,
                     Map<String, RequestHandler.Factory> requestHandlersFactories) {
        this.responseHandler = responseHandler;
        this.requestHandlersFactories = requestHandlersFactories;
    }

    /**
     * Gets parsed RootRequest. If action intent was defined in {@code Builder.addRequestHandlerFactory()} request
     * will be passed to {@code RequestHandler} which then will generate RootResponse in {@code RequestHandler.getResponse}
     * <p>
     * If there is no handler for action intent, {@code ResponseBuilder.tellResponse(ActionsConfig.ERROR_MESSAGE)}
     * is returned.
     *
     * @param rootRequest - the {@link RootResponse} object that contains request from Google Actions
     */
    public void handleRequest(RootRequest rootRequest) {
        responseHandler.onPrepareContentType(ActionsConfig.HTTP_CONTENT_TYPE_JSON);
        responseHandler.onPrepareResponseHeaders(ActionsConfig.RESPONSE_HEADERS);

        String actionIntent = AssistantUtils.getActionIntent(rootRequest);
        if (actionIntent != null && requestHandlersFactories.containsKey(actionIntent)) {
            RequestHandler requestHandler = requestHandlersFactories.get(actionIntent).create(rootRequest);
            responseHandler.onResponse(requestHandler.getResponse());
        } else {
            responseHandler.onResponse(ResponseBuilder.tellResponse(ActionsConfig.ERROR_MESSAGE));
        }
    }

    /**
     * Constructs a {@code AssistantActions.Builder}.
     */
    public static class Builder {
        private ResponseHandler responseHandler;

        private final Map<String, RequestHandler.Factory> requestHandlersFactories = new HashMap<>();

        /**
         * @param responseHandler - the {@link ResponseHandler} object that handles responses from AssistantActions.
         *                        {@code RootResponse} is direct response for Google Actions API and should be passed
         *                        back as POST response.
         */
        public Builder(ResponseHandler responseHandler) {
            this.responseHandler = responseHandler;
        }

        /**
         * Sets {@code RequestHandler.Factory} which creates {@code RequestHandler} to handle action intent.
         *
         * @param actionIntent - unique action intent to handle
         * @param factory      - the {@link RequestHandler.Factory} object that creates {@link RequestHandler} to
         *                     handle given action intent
         * @return this {@code AssistantActions.Builder}
         */
        public Builder addRequestHandlerFactory(String actionIntent, RequestHandler.Factory factory) {
            this.requestHandlersFactories.put(actionIntent, factory);
            return this;
        }

        /**
         * Returns an {@code AssistantActions} built from parameters set by the setter methods.
         *
         * @return
         */
        public AssistantActions build() {
            return new AssistantActions(responseHandler, requestHandlersFactories);
        }
    }
}
