# Unofficial Google Actions Java SDK

Official [Google Actions SDK](https://github.com/actions-on-google/actions-on-google-nodejs) is written in Node.js. But in many situations voice interfaces like Google Home or Google Assistant will extend or replace mobile apps. If you are old fashioned Android engineer and the most of your code is already written in Java, why not reuse it and build voice extension to app on your own? And this is the main reason to build Google Actions Java SDK - enabling as much developers as possible to build their brilliant ideas for Google Assistant and Home.

Currently this is just working proof of concept of Google Actions Java SDK. It means that there is no documentation, fixed interface, (not much) unit tests and many, many others.  

Google Actions Java SDK is build based on official Node.js library, but it's not a mirror copy of it. The goal is to make it fully compatible with [Conversational Protocol](https://developers.google.com/actions/reference/conversation) of Assistant Platform.

## About project
Project is split into two modules:

### Assistant Actions Java SDK
This code is responsible for handling requests and responses compatible with [Conversational Protocol](https://developers.google.com/actions/reference/conversation). 

### Assistant Actions Java Sample
Example projects showing how Assistant Actions SDK can be used in AppEngine Java project. For now Servlet is able to greet user and repeat utterance.

## How to work with limited SDK

Even if it's very early stage project and there is not much utils in it, entire communication with Google Actions is based on proper responses. So even if you find any limitations you can always build `RootResponse` object by hand which in a moment of writing this is fully compatible with [Conversational Protocol](https://developers.google.com/actions/reference/conversation). Same with `RootRequest` - object should reflect all data which Google Actions send to us.

## Download

Library can be downloaded from jCenter:

```gradle
repositories {
    jcenter()
}

dependencies {
    compile 'com.frogermcs.gactions:gactions:0.1.1'
}
```

## Code

Here is example code showing how to use Google Actions Java SDK

```java
AssistantActions assistantActions =
        new AssistantActions.Builder(new AppEngineResponseHandler(response))
                .addRequestHandlerFactory(StandardIntents.MAIN, new MainRequestHandlerFactory())
                .addRequestHandlerFactory(StandardIntents.TEXT, new TextRequestHandlerFactory())
                .addRequestHandlerFactory(StandardIntents.PERMISSION, new MyPermissionRequestHandlerFactory())
                .build();

assistantActions.handleRequest(request);
```

To build `AssistantActions` object, we need to pass implementation of `ResponseHandler` interface. This class will be responsible for passing json response to Google Actions.
Then we need to build intents mapping to delegate request to proper `RequestHandlers`. RequestHandlers are responsible for preparing response for Google Actions.  
At the end we need to pass request coming from Google Actions to our `AssistantActions` object.

### Example implementation

Here are the most important classes from example AppEngine Java implementation 

`ActionsServlet` - entry class in our endpoint.
 
```java
public class ActionsServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AssistantActions assistantActions =
                new AssistantActions.Builder(new AppEngineResponseHandler(response))
                        .addRequestHandlerFactory(StandardIntents.MAIN, new MainRequestHandlerFactory())
                        .addRequestHandlerFactory(StandardIntents.TEXT, new TextRequestHandlerFactory())
                        .addRequestHandlerFactory(StandardIntents.PERMISSION, new MyPermissionRequestHandlerFactory())
                        .build();

        assistantActions.handleRequest(parseActionRequest(request));
    }

    //...
}
```

`AppEngineResponseHandler` - implementation or `ResponseHandler`. Method `onResponse(RootResponse rootResponse)` passes back prepared response to HttpServletResponse.

```java
public class AppEngineResponseHandler implements ResponseHandler {
    private final HttpServletResponse httpServletResponse;

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
        gson.toJson(rootResponse, httpServletResponse.getWriter());
    }
}

```

`MainRequestHandler` - In response to initial Intent `assistant.intent.action.MAIN` we are asking user for NAME permission.
 
```java
public class MainRequestHandler extends RequestHandler {
    MainRequestHandler(RootRequest rootRequest) {
        super(rootRequest);
    }

    @Override
    public RootResponse getResponse() {
        return ResponseBuilder.askForPermissionResponse("See how permissions work",
                SupportedPermissions.NAME);
    }
}
```

`MyPermissionRequestHandler` - whether permission is granted or not, we asking user to tell us something so we'll be able to repeat this response.

```java
public class MyPermissionRequestHandler extends PermissionRequestHandler {

    MyPermissionRequestHandler(RootRequest rootRequest) {
        super(rootRequest);
    }

    @Override
    public RootResponse getResponse() {
        UserProfile userProfile = getUserProfile();
        if (isPermissionGranted() && userProfile != null) {
            return ResponseBuilder.askResponse("Hey " + userProfile.given_name + ". It's nice to meet you!" +
                    "Now tell me something so I could repeat it.");

        } else {
            return ResponseBuilder.askResponse("Hey. I don't know your name, but it's ok. :)" +
                    "Now tell me something so I could repeat it.");
        }
    }
}
```

`TextRequestHandler` - finally we're replying what user's just said. 

```java
public class TextRequestHandler extends RequestHandler {

    TextRequestHandler(RootRequest rootRequest) {
        super(rootRequest);
    }

    @Override
    public RootResponse getResponse() {
        return ResponseBuilder.tellResponse("You've just said: " + getRootRequest().inputs.get(0).raw_inputs.get(0).query);
    }
}
```

## How to deploy this project to our Google Cloud

This description isn't very detailed. It's pretty similar to description in [official documentation](https://developers.google.com/actions/develop/sdk/), but instead of Node.js we are using Java environment on AppEngine. 

### Google Cloud

- Follow steps from here: https://cloud.google.com/sdk/docs/. At the end you should have created Project, know your application id, and be able to use gcloud on your computer. 

### Configuration

Files to edit:
- google-actions-java-sample/src/main/webapp/WEB-INF/appengine-web.xml -> Edit application_id (your project id from https://console.cloud.google.com/, if not edited it's fancy name like "mythic-origin-36343").
- google-actions-java-sample/action.json -> Edit application_id (setup endpoint where Google Actions will be able to reach your servlet)

If you have Google Cloud SDK already installed on you machine, and you are ready to deploy, use this gradle task:
 
 `$ ./gradlew google-actions-java-sample:appengineDeploy`

### Testing

Just visit [Web Simulator](https://developers.google.com/actions/tools/web-simulator) and start testing!

![Web Simulator](https://raw.githubusercontent.com/frogermcs/Google-Actions-Java-SDK/master/art/actions_web_simulator.png "Web Simulator")

## TODO
This is very general list of things planned to do to make this project as useful as possible. Your commitment is highly appreciated!

- Better project structure, code cleanup and style rules
- Add ssml support to responses
- API.AI support (based on official SDK)
- Keep conversation context 
- Unit tests (at least 70% coverage)
- Build and distribute as a java library


## License
See LICENSE.md.