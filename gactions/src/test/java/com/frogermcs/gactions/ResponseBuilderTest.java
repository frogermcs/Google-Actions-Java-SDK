package com.frogermcs.gactions;

import com.frogermcs.gactions.api.SupportedPermissions;
import com.frogermcs.gactions.api.response.RootResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by froger_mcs on 28/04/2017.
 */
public class ResponseBuilderTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testShouldBuildTellResponse() throws Exception {
        String expectedSpeech = "expected_speech";
        RootResponse rootResponse = ResponseBuilder.tellResponse(expectedSpeech);
        assertEquals(expectedSpeech, rootResponse.finalResponse.speechResponse.textToSpeech);
    }

    @Test
    public void testShouldBuildAskResponse() throws Exception {
        String expectedPrompt = "expected_prompt";
        RootResponse rootResponse = ResponseBuilder.askResponse(expectedPrompt);
        assertEquals(true, rootResponse.expectUserResponse);
        assertEquals(expectedPrompt, rootResponse.expectedInputs.get(0).inputPrompt.initialPrompts.get(0).textToSpeech);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPermission_whenPermissionContextIsEmpty_thenShouldThrowException() throws Exception {
        ResponseBuilder.askForPermissionResponse(null, new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPermission_whenPermissionsAreEmpty_thenShouldThrowException() throws Exception {
        ResponseBuilder.askForPermissionResponse("Lorem ipsum", new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPermission_whenAnyPermissionIsIncorrect_thenShouldThrowException() throws Exception {
        ArrayList<String> permissions = new ArrayList<>();
        permissions.add(SupportedPermissions.DEVICE_COARSE_LOCATION.name());
        permissions.add("incorrect permission");
        ResponseBuilder.askForPermissionResponse("Lorem ipsum", permissions);
    }
}