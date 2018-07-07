package com.example.aspect.aoplib.UITrace;


import android.util.Log;

import com.example.aspect.aoplib.ClassTrace;
import com.example.aspect.aoplib.IgnoreClassTrace;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

public class VivoFragmentTraceV4 {
    private final static String TAG = "!!!VivoFragmentTraceV4";

    public static void traceFragmentResume(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.getAnnotation(IgnoreClassTrace.class) != null) {
            //方法已添加忽略注解，不做处理
            return;
        }
        android.support.v4.app.Fragment targetFragment = (android.support.v4.app.Fragment) joinPoint.getTarget();
        if (targetFragment.getClass().getAnnotation(IgnoreClassTrace.class) != null) {
            //Fragment已添加忽略注解，不做处理
            return;
        }

        String methodDeclaringClass = targetMethod.getDeclaringClass().getName();
        if (targetMethod.getDeclaringClass().getAnnotation(ClassTrace.class) == null) {
            //添加注解的方法所在的类没有注解声明，不做处理
            return;
        }

        //根据是否隐藏、是否用户可见判定onResume
        if (!targetFragment.isHidden() && targetFragment.getUserVisibleHint()) {
             Log.e(targetFragment.getClass().getName(),"onResume");
        }
    }

    public static void traceFragmentHidden(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.getAnnotation(IgnoreClassTrace.class) != null) {
            return;
        }
        android.support.v4.app.Fragment targetFragment = (android.support.v4.app.Fragment) joinPoint.getTarget();
        if (targetFragment.getClass().getAnnotation(IgnoreClassTrace.class) != null) {
            return;
        }

        String methodDeclaringClass = targetMethod.getDeclaringClass().getName();
        if (targetMethod.getDeclaringClass().getAnnotation(ClassTrace.class) == null) {
            return;
        }

        //获取连接点函数的参数
        boolean hidden = (boolean)joinPoint.getArgs()[0];
        if (!hidden) {
            if (targetFragment.isResumed()) {
                if (targetFragment.getUserVisibleHint()) {
                     Log.e(targetFragment.getClass().getName(),"onHiddenChange");
                }
            }
        }
    }

    public static void traceFragmentUserVisible(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.getAnnotation(IgnoreClassTrace.class) != null) {
            return;
        }
        android.support.v4.app.Fragment targetFragment = (android.support.v4.app.Fragment) joinPoint.getTarget();
        if (targetFragment.getClass().getAnnotation(IgnoreClassTrace.class) != null) {
            return;
        }

        String methodDeclaringClass = targetMethod.getDeclaringClass().getName();
        if (targetMethod.getDeclaringClass().getAnnotation(ClassTrace.class) == null) {
            return;
        }

        //获取连接点函数的参数
        boolean isVisible = (boolean)joinPoint.getArgs()[0];
        Log.e(TAG ,"class:" + targetFragment.getClass().getName() +"--userVisible:" + isVisible + "--isResumed:" + targetFragment.isResumed() + "--targetFragment.isHidden:" + targetFragment.isHidden());
        if (isVisible) {
            if (targetFragment.isResumed()) {
                if (!targetFragment.isHidden()) {
                     Log.e(targetFragment.getClass().getName(),"userVisible");
                }
            }
        }
    }
}
