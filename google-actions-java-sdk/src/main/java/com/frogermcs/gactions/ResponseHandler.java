package com.frogermcs.gactions;

import com.frogermcs.gactions.api.response.RootResponse;

import java.util.Map;

/**
 * The {@code ResponseHandler} is the interface for class which handles responses for Google Actions API.
 * {@link com.frogermcs.gactions.AssistantActions} passes generated responses ({@link RootResponse}) which then
 * should be passed back as response for POST request from Google Assistant.
 */
public interface ResponseHandler {
    /**
     * Set proper contentType for POST request for Google Actions API
     *
     * @param contentType - contentType defined in {@code ActionsConfig.HTTP_CONTENT_TYPE_JSON}
     */
    void onPrepareContentType(String contentType);

    /**
     * Set headers for POST request for Google Actions API
     *
     * @param headers - headers defined in {@code ActionsConfig.RESPONSE_HEADERS}
     */
    void onPrepareResponseHeaders(Map<String, String> headers);

    /**
     * Response for POST request from Google Actions API
     *
     * @param rootResponse - the {@link RootResponse} object that contains response for Google Actions API request
     */
    void onResponse(RootResponse rootResponse);
}
