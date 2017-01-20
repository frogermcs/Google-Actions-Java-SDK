package com.frogermcs.gactions.api;

/**
 * Created by froger_mcs on 17/01/2017.
 */
public class StandardIntents {
    /**
     * Assistant fires MAIN intent for queries like [talk to $action].
     */
    public static final String MAIN = "assistant.intent.action.MAIN";
    /**
     * Assistant fires TEXT intent when action issues ask intent.
     */
    public static final String TEXT = "assistant.intent.action.TEXT";
    /**
     * Assistant fires PERMISSION intent when action invokes askForPermission.
     */
    public static final String PERMISSION = "assistant.intent.action.PERMISSION";
}
