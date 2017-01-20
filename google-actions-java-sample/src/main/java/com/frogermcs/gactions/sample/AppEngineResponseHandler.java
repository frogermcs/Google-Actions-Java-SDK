package com.frogermcs.gactions.sample;

import com.frogermcs.gactions.ResponseHandler;
import com.frogermcs.gactions.api.response.RootResponse;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by froger_mcs on 19/01/2017.
 */
public class AppEngineResponseHandler implements ResponseHandler {
    private final HttpServletResponse httpServletResponse;
    private final Gson gson;

    public AppEngineResponseHandler(HttpServletResponse httpServletResponse) {
        this(httpServletResponse, new Gson());
    }

    public AppEngineResponseHandler(HttpServletResponse httpServletResponse, Gson gson) {
        this.httpServletResponse = httpServletResponse;
        this.gson = gson;
    }

    @Override
    public void onPrepareContentType(String contentType) {
        httpServletResponse.setContentType(contentType);
    }

    @Override
    public void onPrepareResponseHeaders(Map<String, String> headers) {
        for (String headerName : headers.keySet()) {
            httpServletResponse.addHeader(headerName, headers.get(headerName));
        }
    }

    @Override
    public void onResponse(RootResponse rootResponse) {
        try {
            gson.toJson(rootResponse, httpServletResponse.getWriter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
