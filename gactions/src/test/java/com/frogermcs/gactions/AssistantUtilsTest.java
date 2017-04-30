package com.frogermcs.gactions;

import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.testUtils.TestObjects;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by froger_mcs on 30/04/2017.
 */
public class AssistantUtilsTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testShouldReturnActionIntent() throws Exception {
        String expectedIntent = "expected_intent";
        RootRequest rootRequest = TestObjects.requestWithIntent(expectedIntent);
        assertEquals(expectedIntent, AssistantUtils.getActionIntent(rootRequest));
    }

    @Test
    public void testActionIntent_whenNoInputs_thenShouldReturnNull() throws Exception {
        RootRequest rootRequest = new RootRequest();
        assertNull(AssistantUtils.getActionIntent(rootRequest));
    }
}