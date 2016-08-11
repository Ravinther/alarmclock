package com.mopub.common.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Reflection {

    public static class MethodBuilder {
        private Class mClass;
        private final Object mInstance;
        private boolean mIsAccessible;
        private boolean mIsStatic;
        private final String mMethodName;
        private List mParameterClasses;
        private List mParameters;

        public MethodBuilder(Object instance, String methodName) {
            this.mInstance = instance;
            this.mMethodName = methodName;
            this.mParameterClasses = new ArrayList();
            this.mParameters = new ArrayList();
            this.mClass = instance != null ? instance.getClass() : null;
        }

        public MethodBuilder addParam(Class clazz, Object parameter) {
            this.mParameterClasses.add(clazz);
            this.mParameters.add(parameter);
            return this;
        }

        public MethodBuilder setAccessible() {
            this.mIsAccessible = true;
            return this;
        }

        public MethodBuilder setStatic(Class clazz) {
            this.mIsStatic = true;
            this.mClass = clazz;
            return this;
        }

        public Object execute() {
            Method method = Reflection.getDeclaredMethodWithTraversal(this.mClass, this.mMethodName, (Class[]) this.mParameterClasses.toArray(new Class[this.mParameterClasses.size()]));
            if (this.mIsAccessible) {
                method.setAccessible(true);
            }
            Object[] parameters = this.mParameters.toArray();
            if (this.mIsStatic) {
                return method.invoke(null, parameters);
            }
            return method.invoke(this.mInstance, parameters);
        }
    }

    public static Method getDeclaredMethodWithTraversal(Class clazz, String methodName, Class... parameterTypes) {
        Class currentClass = clazz;
        while (currentClass != null) {
            try {
                return currentClass.getDeclaredMethod(methodName, parameterTypes);
            } catch (NoSuchMethodException e) {
                currentClass = currentClass.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static boolean classFound(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
