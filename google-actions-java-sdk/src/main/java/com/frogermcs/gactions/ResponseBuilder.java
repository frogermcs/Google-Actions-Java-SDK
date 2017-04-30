package com.frogermcs.gactions;

import com.frogermcs.gactions.api.StandardIntents;
import com.frogermcs.gactions.api.SupportedPermissions;
import com.frogermcs.gactions.api.response.*;

import java.util.*;

/**
 * Response builder for Google Actions API. There are three general types of responses: Tell (text feedback for user),
 * Ask (asking user for additional data), AskForPermission (asking user for permissions).
 */
public class ResponseBuilder {

    /**
     * @param message - speech response for Google Actions request
     * @return {@link RootResponse} object that contains speech response for Google Actions request
     */
    public static RootResponse tellResponse(String message) {
        RootResponse rootResponse = new RootResponse();
        rootResponse.expect_user_response = false;
        rootResponse.final_response = new FinalResponse();
        rootResponse.final_response.speech_response = new SpeechResponse(message, null);
        return rootResponse;
    }

    /**
     * @param message - speech response for Google Actions request
     * @return {@link RootResponse} object that uses speech response to ask user for additional data
     */
    public static RootResponse askResponse(String message) {
        return askResponse(message, null, null);
    }

    /**
     * @param message        - speech response for Google Actions request
     * @param noInputPrompts
     * @return {@link RootResponse} object that uses speech response to ask user for additional data
     */
    public static RootResponse askResponse(String message, String[] noInputPrompts) {
        return askResponse(message, null, noInputPrompts);
    }

    /**
     * @param message           - speech response for Google Actions request
     * @param conversationToken
     * @param noInputPrompts
     * @return {@link RootResponse} object that uses speech response to ask user for additional data
     */
    public static RootResponse askResponse(String message, String conversationToken, String[] noInputPrompts) {
        RootResponse rootResponse = new RootResponse();
        rootResponse.expect_user_response = true;
        rootResponse.conversation_token = conversationToken;
        rootResponse.expected_inputs = new ArrayList<>();

        ExpectedInputs expectedInput = new ExpectedInputs();
        expectedInput.input_prompt = new InputPrompt();
        expectedInput.input_prompt.initial_prompts = Collections.singletonList(new SpeechResponse(message, null));

        if (noInputPrompts != null && noInputPrompts.length > 0) {
            expectedInput.input_prompt.no_input_prompts = new ArrayList<>();
            for (String noInputPrompt : noInputPrompts) {
                expectedInput.input_prompt.no_input_prompts.add(new SpeechResponse(noInputPrompt, null));
            }

        }

        expectedInput.possible_intents = new ArrayList<>();
        expectedInput.possible_intents.add(new ExpectedIntent(StandardIntents.TEXT));

        rootResponse.expected_inputs.add(expectedInput);
        return rootResponse;
    }

    /**
     * @param permissionContext -  Context why the permission is being asked; it's the TTS
     *                          prompt prefix (action phrase) we ask the user.
     * @param permissions       - Array of permissions Assistant supports, each of
     *                          which comes from Assistant.SupportedPermissions.
     * @return {@link RootResponse} object that is sent to Assistant to ask for the user's permission
     * @throws IllegalArgumentException when permissionContext or permissions are null or empty. Exception is also
     *                                  thrown when any of given permission isn't one of: [NAME, DEVICE_PRECISE_LOCATION, DEVICE_COARSE_LOCATION]
     */
    public static RootResponse askForPermissionResponse(String permissionContext, SupportedPermissions... permissions) {
        List<String> permissionsStr = new ArrayList<>();
        for (SupportedPermissions permission : permissions) {
            permissionsStr.add(permission.name());
        }

        return askForPermissionResponse(permissionContext, permissionsStr);
    }

    /**
     * @param permissionContext -  Context why the permission is being asked; it's the TTS
     *                          prompt prefix (action phrase) we ask the user.
     * @param permissions       - Array of permissions Assistant supports, each of
     *                          which comes from Assistant.SupportedPermissions.
     * @return {@link RootResponse} object that is sent to Assistant to ask for the user's permission
     * @throws IllegalArgumentException when permissionContext or permissions are null or empty. Exception is also
     *                                  thrown when any of given permission isn't one of: [NAME, DEVICE_PRECISE_LOCATION, DEVICE_COARSE_LOCATION]
     */
    public static RootResponse askForPermissionResponse(String permissionContext, String... permissions) {
        return askForPermissionResponse(permissionContext, Arrays.asList(permissions));
    }

    /**
     * @param permissionContext -  Context why the permission is being asked; it's the TTS
     *                          prompt prefix (action phrase) we ask the user.
     * @param permissions       - Array of permissions Assistant supports, each of
     *                          which comes from Assistant.SupportedPermissions.
     * @return {@link RootResponse} object that is sent to Assistant to ask for the user's permission
     * @throws IllegalArgumentException when permissionContext or permissions are null or empty. Exception is also
     *                                  thrown when any of given permission isn't one of: [NAME, DEVICE_PRECISE_LOCATION, DEVICE_COARSE_LOCATION]
     */
    public static RootResponse askForPermissionResponse(String permissionContext, Collection<String> permissions) throws IllegalArgumentException {
        if (permissionContext == null || permissionContext.length() == 0) {
            throw new IllegalArgumentException("permissionContext argument cannot be null");
        }

        if (permissions == null || permissions.isEmpty()) {
            throw new IllegalArgumentException("At least one permission needed.");
        }

        try {
            for (String permission : permissions) {
                SupportedPermissions.valueOf(permission);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Assistant permission must be one of [NAME, DEVICE_PRECISE_LOCATION, DEVICE_COARSE_LOCATION]");
        }

        RootResponse rootResponse = new RootResponse();
        rootResponse.expect_user_response = true;

        PermissionValueSpec permissionValueSpec = new PermissionValueSpec();
        permissionValueSpec.opt_context = permissionContext;
        permissionValueSpec.permissions = new ArrayList<>(permissions);

        InputValueSpec inputValueSpec = new InputValueSpec();
        inputValueSpec.permission_value_spec = permissionValueSpec;

        ExpectedIntent expectedIntent = new ExpectedIntent(StandardIntents.PERMISSION);
        expectedIntent.input_value_spec = inputValueSpec;

        ExpectedInputs expectedInput = new ExpectedInputs();
        expectedInput.possible_intents = new ArrayList<>();
        expectedInput.possible_intents.add(expectedIntent);

        rootResponse.expected_inputs = new ArrayList<>();
        rootResponse.expected_inputs.add(expectedInput);

        return rootResponse;
    }
}
