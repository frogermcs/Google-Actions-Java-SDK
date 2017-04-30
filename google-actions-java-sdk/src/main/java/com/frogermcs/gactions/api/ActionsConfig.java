package com.frogermcs.gactions.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Google Actions API config
 */
public class ActionsConfig {
    /**
     * Default tell-response for intent actions which aren't handled by user RequestHandler - Intent Action mapping
     */
    public static final String ERROR_MESSAGE = "Sorry, I am unable to process your request.";
    /**
     * Header configurations for Google Actions API
     */
    public static final String CONVERSATION_API_VERSION_HEADER = "Google-Assistant-API-Version";
    public static final String CONVERSATION_API_VERSION = "v1";
    public static final String HTTP_CONTENT_TYPE_JSON = "application/json";
    public static final Map<String, String> RESPONSE_HEADERS;

    static {
        RESPONSE_HEADERS = new HashMap<>();
        RESPONSE_HEADERS.put(CONVERSATION_API_VERSION_HEADER, CONVERSATION_API_VERSION);
    }

    /**
     * Permission granted argument.
     */
    public static final String ARG_PERMISSION_GRANTED = "permission_granted";
}
