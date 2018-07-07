package com.example.aspect.aoplib;

public class MessageUtils {

    public static String buildLogMessage(String methodName, long methodDuration) {
        StringBuilder message = new StringBuilder();
        message.append("xqeAspect --> ");
        message.append(methodName);
        message.append(" --> ");
        message.append("[");
        message.append(methodDuration);
        message.append("ms");
        message.append("]");

        return message.toString();
    }
}
