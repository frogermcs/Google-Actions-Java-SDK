package com.frogermcs.gactions.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frogermcs.gactions.ResponseHandler;
import com.frogermcs.gactions.api.response.RootResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by froger_mcs on 19/01/2017.
 */
public class AppEngineResponseHandler implements ResponseHandler {
    private final HttpServletResponse httpServletResponse;
    private final ObjectMapper objectMapper;

    public AppEngineResponseHandler(HttpServletResponse httpServletResponse) {
        this(httpServletResponse, new ObjectMapper());
    }

    public AppEngineResponseHandler(HttpServletResponse httpServletResponse, ObjectMapper objectMapper) {
        this.httpServletResponse = httpServletResponse;
        this.objectMapper = objectMapper;
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
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            objectMapper.writeValue(httpServletResponse.getWriter(), rootResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
