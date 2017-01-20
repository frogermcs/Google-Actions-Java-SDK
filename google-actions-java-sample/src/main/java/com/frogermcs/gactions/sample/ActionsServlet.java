package com.frogermcs.gactions.sample;

import com.frogermcs.gactions.AssistantActions;
import com.frogermcs.gactions.api.StandardIntents;
import com.frogermcs.gactions.api.request.RootRequest;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class ActionsServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(ActionsServlet.class.getName());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("Hello, world Google Actions");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("POST: " + request);

        AssistantActions assistantActions =
                new AssistantActions.Builder(new AppEngineResponseHandler(response))
                        .addRequestHandlerFactory(StandardIntents.MAIN, new MainRequestHandlerFactory())
                        .addRequestHandlerFactory(StandardIntents.TEXT, new TextRequestHandlerFactory())
                        .build();

        assistantActions.handleRequest(parseActionRequest(request));
    }

    private RootRequest parseActionRequest(HttpServletRequest request) throws IOException {
        JsonReader jsonReader = new JsonReader(request.getReader());
        return new Gson().fromJson(jsonReader, RootRequest.class);
    }
}
