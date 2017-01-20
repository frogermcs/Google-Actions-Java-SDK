package com.frogermcs.gactions.sample;

import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.ResponseBuilder;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;

/**
 * Created by froger_mcs on 19/01/2017.
 */
public class MainRequestHandler implements RequestHandler {
    @Override
    public RootResponse onRequest(RootRequest rootRequest) {
        return ResponseBuilder.askResponse("Hey, it works! Now tell something so I could repeat it.");
    }
}