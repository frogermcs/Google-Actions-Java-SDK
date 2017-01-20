package com.frogermcs.gactions.api;

import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;

/**
 * Created by froger_mcs on 19/01/2017.
 */
public interface RequestHandler {

    RootResponse onRequest(RootRequest rootRequest);

    public static interface Factory {
        RequestHandler create();
    }
}
