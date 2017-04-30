package com.frogermcs.gactions.sample;

import com.frogermcs.gactions.ResponseBuilder;
import com.frogermcs.gactions.api.permission.PermissionRequestHandler;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.request.UserProfile;
import com.frogermcs.gactions.api.response.RootResponse;

/**
 * Created by froger_mcs on 29/04/2017.
 */
public class MyPermissionRequestHandler extends PermissionRequestHandler {

    MyPermissionRequestHandler(RootRequest rootRequest) {
        super(rootRequest);
    }

    @Override
    public RootResponse getResponse() {
        UserProfile userProfile = getUserProfile();
        if (isPermissionGranted() && userProfile != null) {
            return ResponseBuilder.askResponse("Hey " + userProfile.given_name + ". It's nice to meet you! " +
                    "Now tell me something so I could repeat it.");

        } else {
            return ResponseBuilder.askResponse("Hey. I don't know your name, but it's ok. :) " +
                    "Now tell me something so I could repeat it.");
        }
    }
}
