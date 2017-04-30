package com.frogermcs.gactions;

import com.frogermcs.gactions.api.ActionsConfig;
import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.api.request.Inputs;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

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

        verify(responseHandlerMock).onResponse(expectedResponse);
    }

    @Test
    public void testResponse_whenHandlerForResponseExist_thenItShouldGenerateResponse() throws Exception {
        RootResponse expectedResponse = ResponseBuilder.tellResponse("lorem ipsum");
        String expectedIntent = "INTENT";

        RequestHandler.Factory requestHandlerFactory = mock(RequestHandler.Factory.class);
        RequestHandler requestHandler = mock(RequestHandler.class);

        assistantActions = new AssistantActions.Builder(responseHandlerMock)
                .addRequestHandlerFactory(expectedIntent, requestHandlerFactory)
                .build();

        RootRequest expectedRootRequest = new RootRequest();
        expectedRootRequest.inputs = new ArrayList<>();
        Inputs input = new Inputs();
        input.intent = expectedIntent;
        expectedRootRequest.inputs.add(input);

        when(requestHandlerFactory.create(expectedRootRequest)).thenReturn(requestHandler);
        when(requestHandler.getResponse()).thenReturn(expectedResponse);

        assistantActions.handleRequest(expectedRootRequest);

        verify(requestHandler).getResponse();
        verify(responseHandlerMock).onResponse(expectedResponse);
    }
}