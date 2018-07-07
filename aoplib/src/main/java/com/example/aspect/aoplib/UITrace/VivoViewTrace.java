package com.example.aspect.aoplib.UITrace;

import android.util.Log;
import android.view.View;

import org.aspectj.lang.JoinPoint;

public class VivoViewTrace {
    private final static String TAG = "!!!VivoViewTrace";

    public static void traceView(JoinPoint joinPoint) {
        View targetView = (View) joinPoint.getTarget();
        targetView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
                Log.e(TAG, "onViewAttachedToWindow: " + v.getClass().getName());
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                Log.e(TAG, "onViewDetachedFromWindow: " + v.getClass().getName());
            }
        });
    }
}
