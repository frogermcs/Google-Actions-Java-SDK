package com.frogermcs.gactions;

import com.frogermcs.gactions.api.ActionsConfig;
import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Created by froger_mcs on 20/01/2017.
 */
public class AssistantActionsTest {

    AssistantActions assistantActions;

    @Mock
    ResponseHandler responseHandlerMock;

    Map<String, RequestHandler.Factory> requestHandlersFactories;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        requestHandlersFactories = new HashMap<>();
        assistantActions = new AssistantActions.Builder(responseHandlerMock)
                .build();
    }

    @After
    public void tearDown() throws Exception {
        requestHandlersFactories.clear();
    }

    @Test
    public void testHeaders_whenRequestIsHandled_thenPrepareProperHeaders() throws Exception {
        RootRequest rootRequest = new RootRequest();
        assistantActions.handleRequest(rootRequest);
        verify(responseHandlerMock).onPrepareContentType(eq(ActionsConfig.HTTP_CONTENT_TYPE_JSON));
        verify(responseHandlerMock).onPrepareResponseHeaders(eq(ActionsConfig.RESPONSE_HEADERS));
    }

    @Test
    public void testResponse_whenNoHandlerForResponse_thenShouldReplyWithDefaultError() throws Exception {
        RootRequest rootRequest = new RootRequest();
        RootResponse expectedResponse = ResponseBuilder.tellResponse(ActionsConfig.ERROR_MESSAGE);

        assistantActions.handleRequest(rootRequest);

        verify(responseHandlerMock).onResponse(eq(expectedResponse));
    }
}