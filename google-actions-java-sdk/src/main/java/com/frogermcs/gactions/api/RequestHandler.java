package com.frogermcs.gactions.api;

import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;

/**
 * The {@code RequestHandler} is the class which handles Google Actions API requests. It should be used in
 * {@link com.frogermcs.gactions.AssistantActions} mappings to handle action intents.
 */
public abstract class RequestHandler {

    private final RootRequest rootRequest;

    protected RequestHandler(RootRequest rootRequest) {
        this.rootRequest = rootRequest;
    }

    /**
     * @return the {@link RootRequest} object - Google Actions API request
     */
    public RootRequest getRootRequest() {
        return rootRequest;
    }

    /**
     * @return UserId from Google Actions API request
     */
    public String getUserId() {
        return rootRequest.user.user_id;
    }

    /**
     * @return the {@link RootResponse} object, response for Google Actions API request
     */
    public abstract RootResponse getResponse();

    public static abstract class Factory {
        /**
         * @param rootRequest - the {@link RootResponse} object that contains request from Google Actions
         * @return the {@link RequestHandler} object, handler for Google Actions API requests
         */
        public abstract RequestHandler create(RootRequest rootRequest);
    }
}
