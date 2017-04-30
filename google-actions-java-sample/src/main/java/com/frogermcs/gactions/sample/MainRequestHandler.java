package com.frogermcs.gactions.sample;

import com.frogermcs.gactions.ResponseBuilder;
import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.api.SupportedPermissions;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;

/**
 * Created by froger_mcs on 19/01/2017.
 */
public class MainRequestHandler extends RequestHandler {
    MainRequestHandler(RootRequest rootRequest) {
        super(rootRequest);
    }

    @Override
    public RootResponse getResponse() {
        return ResponseBuilder.askForPermissionResponse("See how permissions work",
                SupportedPermissions.NAME);
    }
}