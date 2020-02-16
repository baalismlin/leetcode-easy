package com.example.leetcode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProblemAgent {

    public static Object agent(Class<?> clazz, Object proxy) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new ProblemHandler(proxy));
    }

    static class ProblemHandler implements InvocationHandler{
        private Object proxy;
        ProblemHandler(Object proxy){
            this.proxy = proxy;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Long start = System.currentTimeMillis();
            Object returnValue = method.invoke(this.proxy, args);
            Long end = System.currentTimeMillis();
            System.out.println("Result: " + returnValue);
            System.out.println("Method " + method.getName() + " completed in " + (end - start) + "ms.");
            return returnValue;
        }
    }
}
