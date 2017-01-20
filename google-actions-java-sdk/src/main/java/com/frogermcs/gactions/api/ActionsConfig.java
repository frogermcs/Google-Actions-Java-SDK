package com.frogermcs.gactions.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class ActionsConfig {
    public static final String ERROR_MESSAGE = "Sorry, I am unable to process your request.";
    public static final String CONVERSATION_API_VERSION_HEADER = "Google-Assistant-API-Version";
    public static final String CONVERSATION_API_VERSION = "v1";
    public static final String HTTP_CONTENT_TYPE_JSON = "application/json";
    public static final Map<String, String> RESPONSE_HEADERS;

    static {
        RESPONSE_HEADERS = new HashMap<>();
        RESPONSE_HEADERS.put(CONVERSATION_API_VERSION_HEADER, CONVERSATION_API_VERSION);
    }
}
