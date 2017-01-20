package com.frogermcs.gactions;

import com.frogermcs.gactions.api.response.RootResponse;

import java.util.Map;

/**
 * Created by froger_mcs on 19/01/2017.
 */
public interface ResponseHandler {

    void onPrepareContentType(String contentType);

    void onPrepareResponseHeaders(Map<String, String> headers);

    void onResponse(RootResponse rootResponse);
}
