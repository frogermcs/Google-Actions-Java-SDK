package com.frogermcs.gactions;

import com.frogermcs.gactions.api.StandardIntents;
import com.frogermcs.gactions.api.response.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by froger_mcs on 19/01/2017.
 */
public class ResponseBuilder {
    public static RootResponse tellResponse(String message) {
        RootResponse rootResponse = new RootResponse();
        rootResponse.expect_user_response = false;
        rootResponse.final_response = new FinalResponse();
        rootResponse.final_response.speech_response = new SpeechResponse(message, null);
        return rootResponse;
    }

    public static RootResponse askResponse(String message) {
        return askResponse(message, null, null);
    }

    public static RootResponse askResponse(String message, String[] noInputPrompts) {
        return askResponse(message, null, noInputPrompts);
    }

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
}
