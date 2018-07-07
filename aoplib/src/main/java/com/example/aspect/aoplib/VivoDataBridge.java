package com.example.aspect.aoplib;

import android.util.Log;

import com.example.aspect.aoplib.UITrace.VivoFragmentTraceV4;
import com.example.aspect.aoplib.UITrace.VivoViewTrace;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class VivoDataBridge {
    private static final String TAG = "VivoDataBridge";

    @Pointcut("within(@com.example.aspect.aoplib.ClassTrace *)")
    public void withinAnnotationClass() {}

    @Pointcut("execution(@com.example.aspect.aoplib.MethodTrace * *(..))")
    public void method(){}

    @Pointcut("call(* com.example.aspect.aspectjtest001.MainActivity.testAnnotationAspect(..))")
    public void callMethod(){} //指定函数被调用时切入

    @Around("method()")
    public Object classTest(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed(); //被注解的方法执行的地方
        stopWatch.stop();

        Log.e("!!!!" + className,MessageUtils.buildLogMessage(methodName,stopWatch.getTotalTimeMillis()));
        return result;
    }

    @Before("callMethod()")  //方法调用前插入代码
    public void beforeMethodCall(JoinPoint joinPoint) {
        Log.e(TAG, "beforeMethodCall: " + joinPoint.getTarget().toString() + "------" + joinPoint.getSignature().getName());
    }

    @Around("callMethod()") //替换原先执行的代码 可调用joinPoint.proceed()执行原先的代码
    public void aroundMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "aroundMethodCall: " + joinPoint.getTarget().toString() + "------" + joinPoint.getSignature().getName());
        joinPoint.proceed();
    }


    @Around("withinAnnotationClass()")
    public void classTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.proceed();
        Log.e(TAG, "classTrace: ===============" + joinPoint.getSignature().getDeclaringTypeName() + "----" + joinPoint.getSignature().getName());
        if (joinPoint.getSignature().getName().equals("setTestBoolean")) {
            boolean arg = (boolean)joinPoint.getArgs()[0];
            Log.e(TAG, "classTrace get arg: " + joinPoint.getTarget().getClass().getName() + "---" + arg);
        }
        if (joinPoint.getSignature().getName().equals("onResume")) {
            Log.e(TAG, "classTrace get value: " + joinPoint.getTarget().getClass().getName() + "---" + joinPoint.getTarget().getClass().getAnnotation(ClassTrace.class).value());
        }

        if (joinPoint.getSignature().getName().equals("setUserVisibleHint")) {
            Log.e(TAG, "classTrace get value: " + joinPoint.getTarget().getClass().getName() + "---" + joinPoint.getTarget().getClass().getAnnotation(ClassTrace.class).value());
            boolean arg = (boolean)joinPoint.getArgs()[0];
            Log.e(TAG, "classTrace get arg: " + joinPoint.getTarget().getClass().getName() + "---" + arg);
            VivoFragmentTraceV4.traceFragmentUserVisible(joinPoint);
        }

        if (joinPoint.getSignature().getName().equals("onAttachedToWindow")) {
            Log.e(TAG, "classTrace get value: " + joinPoint.getTarget().getClass().getName() + "---" + joinPoint.getTarget().getClass().getAnnotation(ClassTrace.class).value());
            VivoViewTrace.traceView(joinPoint);
        }

    }

}
