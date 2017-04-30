package com.frogermcs.gactions.testUtils;

import com.frogermcs.gactions.api.ActionsConfig;
import com.frogermcs.gactions.api.StandardIntents;
import com.frogermcs.gactions.api.request.*;

import java.util.ArrayList;

/**
 * Created by froger_mcs on 30/04/2017.
 */
public class TestObjects {
    public static RootRequest permissionGrantedLocationRequest(boolean granted) {
        RootRequest rootRequest = permissionGrantedRequest(granted);

        rootRequest.device = new Device();
        rootRequest.device.location = new Location();
        rootRequest.device.location.city = "CityName";
        rootRequest.device.location.coordinates = new Coordinates();
        rootRequest.device.location.coordinates.latitude = 1.0;
        rootRequest.device.location.coordinates.longitude = 1.0;
        rootRequest.device.location.formatted_address = "Address CityName";
        rootRequest.device.location.zip_code = "N11RG";

        return rootRequest;
    }

    public static RootRequest permissionGrantedUserProfileRequest(boolean granted) {
        RootRequest rootRequest = permissionGrantedRequest(granted);

        rootRequest.user = new User();
        rootRequest.user.user_id = "abc123";
        rootRequest.user.profile = new UserProfile();
        rootRequest.user.profile.given_name = "Name";
        rootRequest.user.profile.family_name = "LastName";
        rootRequest.user.profile.display_name = "Name LastName";

        return rootRequest;
    }

    public static RootRequest permissionGrantedRequest(boolean granted) {
        RootRequest rootRequest = new RootRequest();
        rootRequest.inputs = new ArrayList<>();
        Inputs inputs = new Inputs();
        inputs.intent = StandardIntents.PERMISSION;
        inputs.arguments = new ArrayList<>();
        Argument argument = new Argument();
        argument.name = ActionsConfig.ARG_PERMISSION_GRANTED;
        argument.text_value = Boolean.toString(granted);
        inputs.arguments.add(argument);
        rootRequest.inputs.add(inputs);

        return rootRequest;
    }

    public static RootRequest requestWithIntent(String intent) {
        RootRequest rootRequest = new RootRequest();
        rootRequest.inputs = new ArrayList<>();
        Inputs inputs = new Inputs();
        inputs.intent = intent;
        rootRequest.inputs.add(inputs);

        return rootRequest;
    }
}
