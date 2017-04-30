package com.frogermcs.gactions.api.permission;

import com.frogermcs.gactions.AssistantUtils;
import com.frogermcs.gactions.api.ActionsConfig;
import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.api.StandardIntents;
import com.frogermcs.gactions.api.request.Argument;
import com.frogermcs.gactions.api.request.Location;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.request.UserProfile;

import javax.annotation.Nullable;

/**
 * The {@code PermissionRequestHandler} is the class which handles Google Actions API permission requests.
 */
public abstract class PermissionRequestHandler extends RequestHandler {
    protected PermissionRequestHandler(RootRequest rootRequest) {
        super(rootRequest);
    }

    /**
     * If action intent from {@link RootRequest} is {@code StandardIntents.PERMISSION}, then return
     * information whether permission was granted or not.
     * <p>
     * Otherwise returns {@code false}.
     *
     * @return boolean value for permission
     */
    public boolean isPermissionGranted() {
        RootRequest rootRequest = getRootRequest();
        if (StandardIntents.PERMISSION.equals(AssistantUtils.getActionIntent(rootRequest))) {
            for (Argument argument : rootRequest.inputs.get(0).arguments) {
                if (ActionsConfig.ARG_PERMISSION_GRANTED.equals(argument.name)) {
                    return Boolean.valueOf(argument.text_value);
                }
            }

        }

        return false;
    }

    /**
     * @return {@link UserProfile} object if permission was granted and object exists in Google Actions request
     */
    @Nullable
    public UserProfile getUserProfile() {
        if (isPermissionGranted()) {
            return getRootRequest().user.profile;
        } else {
            return null;
        }
    }

    /**
     * @return {@link Location} object if permission was granted and object exists in Google Actions request
     */
    @Nullable
    public Location getLocation() {
        if (isPermissionGranted()) {
            return getRootRequest().device.location;
        } else {
            return null;
        }
    }
}
