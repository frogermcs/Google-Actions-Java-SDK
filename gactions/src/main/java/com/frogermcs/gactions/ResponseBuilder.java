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

    public static RootResponse tellResponse(String message) {
        return ResponseBuilder.tellResponse(SpeechResponse.builder().textToSpeech(message).displayText(message).build());
    }

    public static RootResponse tellResponse(SpeechResponse message) {
        RootResponse rootResponse = new RootResponse();
        rootResponse.expectUserResponse = false;
        rootResponse.finalResponse = new FinalResponse();
        rootResponse.finalResponse.speechResponse = message;
        return rootResponse;
    }

    public static RootResponse tellResponseWithRichInput(SpeechResponse message) {
        return ResponseBuilder.tellResponseWithRichInput(message, null, null);
    }
    public static RootResponse tellResponseWithRichInput(SpeechResponse message, String conversationToken, List<SuggestionResponse> suggestions) {
        RichInitialPromptItems richInitialPromptItems = RichInitialPromptItems.builder().simpleResponse(message).build();
        return ResponseBuilder.tellResponseWithRichInput(richInitialPromptItems, conversationToken, suggestions );
    }
    public static RootResponse tellResponseWithRichInput(BasicCard basicCard) {
        return ResponseBuilder.tellResponseWithRichInput(basicCard, null, null);
    }
    public static RootResponse tellResponseWithRichInput(BasicCard basicCard, String conversationToken, List<SuggestionResponse> suggestions) {
        RichInitialPromptItems richInitialPromptItems = RichInitialPromptItems.builder().basicCard(basicCard).build();
        return ResponseBuilder.tellResponseWithRichInput(richInitialPromptItems, conversationToken, suggestions );
    }
    public static RootResponse tellResponseWithRichInput(RichInitialPromptItems richInitialPromptItems) {
        return ResponseBuilder.tellResponseWithRichInput(richInitialPromptItems, null, null);
    }
    public static RootResponse tellResponseWithRichInput(RichInitialPromptItems richInitialPromptItems, String conversationToken, List<SuggestionResponse> suggestions) {
        RootResponse rootResponse = new RootResponse();
        rootResponse.expectUserResponse = false;
        rootResponse.conversationToken = conversationToken;
        rootResponse.finalResponse = new FinalResponse();

        RichInitialPrompt richResponse = RichInitialPrompt.builder().items(Collections.singletonList(richInitialPromptItems)).suggestions(suggestions).build();

        rootResponse.finalResponse.richResponse = richResponse;

        return rootResponse;
    }


    public static RootResponse askResponse(String message) {
        return ResponseBuilder.askResponse(SpeechResponse.builder().textToSpeech(message).displayText(message).build());
    }

    public static RootResponse askResponse(SpeechResponse message) {
        return askResponse(message, null, null);
    }

    public static RootResponse askResponse(String message, String[] noInputPrompts) {
        return askResponse(message, null, noInputPrompts);
    }

    public static RootResponse askResponseWithRichInput(SpeechResponse message) {
        return askResponseWithRichInput(message, null, null, null);
    }
    public static RootResponse askResponseWithRichInput(SpeechResponse message, String conversationToken, List<SpeechResponse> noInputPrompts, List<SuggestionResponse> suggestions ) {
        RichInitialPromptItems richInitialPromptItems = RichInitialPromptItems.builder().simpleResponse(message).build();
        return ResponseBuilder.askResponseWithRichInput(richInitialPromptItems, conversationToken, noInputPrompts, suggestions );
    }
    public static RootResponse askResponseWithRichInput(BasicCard basicCard) {
        return askResponseWithRichInput(basicCard, null, null, null);
    }
    public static RootResponse askResponseWithRichInput(BasicCard basicCard, String conversationToken, List<SpeechResponse> noInputPrompts, List<SuggestionResponse> suggestions ) {
        RichInitialPromptItems richInitialPromptItems = RichInitialPromptItems.builder().basicCard(basicCard).build();
        return ResponseBuilder.askResponseWithRichInput(richInitialPromptItems, conversationToken, noInputPrompts, suggestions );
    }
    public static RootResponse askResponseWithRichInput(RichInitialPromptItems richInitialPromptItems) {
        return askResponseWithRichInput(richInitialPromptItems, null, null, null);
    }
    public static RootResponse askResponseWithRichInput(RichInitialPromptItems richInitialPromptItems, String conversationToken, List<SpeechResponse> noInputPrompts, List<SuggestionResponse> suggestions ) {

        RootResponse rootResponse = new RootResponse();
        rootResponse.expectUserResponse = true;
        rootResponse.conversationToken = conversationToken;
        rootResponse.expectedInputs = new ArrayList<>();

        ExpectedInputs expectedInput = new ExpectedInputs();
        expectedInput.inputPrompt = new InputPrompt();

        RichInitialPrompt richInitialPrompt = RichInitialPrompt.builder().items(Collections.singletonList(richInitialPromptItems)).suggestions(suggestions).build();

        expectedInput.inputPrompt.richInitialPrompt = richInitialPrompt;

        if (noInputPrompts != null && noInputPrompts.size() > 0) {
            expectedInput.inputPrompt.noInputPrompts = noInputPrompts;
        }

        expectedInput.possibleIntents = new ArrayList<>();
        expectedInput.possibleIntents.add(new ExpectedIntent(StandardIntents.TEXT));

        rootResponse.expectedInputs.add(expectedInput);
        return rootResponse;
    }

    /**
     * @param message           - speech response for Google Actions request
     * @param conversationToken
     * @param noInputPrompts
     * @return {@link RootResponse} object that uses speech response to ask user for additional data
     */
    public static RootResponse askResponse(SpeechResponse message, String conversationToken, List<SpeechResponse> noInputPrompts ) {
        RootResponse rootResponse = new RootResponse();
        rootResponse.expectUserResponse = true;
        rootResponse.conversationToken = conversationToken;
        rootResponse.expectedInputs = new ArrayList<>();

        ExpectedInputs expectedInput = new ExpectedInputs();
        expectedInput.inputPrompt = new InputPrompt();
        expectedInput.inputPrompt.initialPrompts = Collections.singletonList(message);

        if (noInputPrompts != null && noInputPrompts.size() > 0) {
            expectedInput.inputPrompt.noInputPrompts = noInputPrompts;
        }

        expectedInput.possibleIntents = new ArrayList<>();
        expectedInput.possibleIntents.add(new ExpectedIntent(StandardIntents.TEXT));

        rootResponse.expectedInputs.add(expectedInput);
        return rootResponse;
    }

    public static RootResponse askResponse(String message, String conversationToken, String[] noInputPrompts) {
        List<SpeechResponse> noInputPromptsConverted = null;
        if (noInputPrompts != null && noInputPrompts.length > 0) {
            List<SpeechResponse> result = new ArrayList<>();
            for(String noInputPrompt : noInputPrompts) {
                noInputPromptsConverted.add(SpeechResponse.builder().textToSpeech(noInputPrompt).displayText(noInputPrompt).build());
            }
        }

        return ResponseBuilder.askResponse(SpeechResponse.builder().textToSpeech(message).displayText(message).build(), conversationToken, noInputPromptsConverted);
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
        rootResponse.expectUserResponse = true;

        PermissionValueSpec permissionValueSpec = new PermissionValueSpec();
        permissionValueSpec.optContext = permissionContext;
        permissionValueSpec.permissions = new ArrayList<>(permissions);

        InputValueSpec inputValueSpec = new InputValueSpec();
        inputValueSpec.permission_value_spec = permissionValueSpec;

        ExpectedIntent expectedIntent = new ExpectedIntent(StandardIntents.PERMISSION);
        expectedIntent.inputValueSpec = inputValueSpec;

        ExpectedInputs expectedInput = new ExpectedInputs();
        expectedInput.possibleIntents = new ArrayList<>();
        expectedInput.possibleIntents.add(expectedIntent);

        rootResponse.expectedInputs = new ArrayList<>();
        rootResponse.expectedInputs.add(expectedInput);

        return rootResponse;
    }
}
