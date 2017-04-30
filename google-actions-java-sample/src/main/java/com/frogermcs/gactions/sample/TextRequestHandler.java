package com.frogermcs.gactions.sample;

import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.ResponseBuilder;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;

/**
 * Created by froger_mcs on 19/01/2017.
 */
public class TextRequestHandler extends RequestHandler {

    TextRequestHandler(RootRequest rootRequest) {
        super(rootRequest);
    }

    @Override
    public RootResponse getResponse() {
        return ResponseBuilder.tellResponse("You've just said: " + getRootRequest().inputs.get(0).raw_inputs.get(0).query);
    }
}
