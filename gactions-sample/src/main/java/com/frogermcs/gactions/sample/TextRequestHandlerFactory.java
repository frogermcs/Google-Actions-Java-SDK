package com.frogermcs.gactions.sample;

import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.api.request.RootRequest;

/**
 * Created by froger_mcs on 19/01/2017.
 */
public class TextRequestHandlerFactory extends RequestHandler.Factory {
    @Override
    public RequestHandler create(RootRequest rootRequest) {
        return new TextRequestHandler(rootRequest);
    }
}
