package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StandardExceptionParser implements ExceptionParser {
    private final TreeSet f4230a;

    public StandardExceptionParser(Context context, Collection additionalPackages) {
        this.f4230a = new TreeSet();
        m5803a(context, additionalPackages);
    }

    public void m5803a(Context context, Collection additionalPackages) {
        this.f4230a.clear();
        Set<String> packages = new HashSet();
        if (additionalPackages != null) {
            packages.addAll(additionalPackages);
        }
        if (context != null) {
            try {
                String appPackage = context.getApplicationContext().getPackageName();
                this.f4230a.add(appPackage);
                ActivityInfo[] ai = context.getApplicationContext().getPackageManager().getPackageInfo(appPackage, 15).activities;
                if (ai != null) {
                    for (ActivityInfo sx : ai) {
                        packages.add(sx.packageName);
                    }
                }
            } catch (NameNotFoundException e) {
                Log.m5754d("No package found");
            }
        }
        for (String packageName : packages) {
            boolean needToAdd = true;
            Iterator i$ = this.f4230a.iterator();
            while (i$.hasNext()) {
                String oldName = (String) i$.next();
                if (packageName.startsWith(oldName)) {
                    needToAdd = false;
                } else {
                    if (oldName.startsWith(packageName)) {
                        this.f4230a.remove(oldName);
                    }
                    if (needToAdd) {
                        this.f4230a.add(packageName);
                    }
                }
            }
            if (needToAdd) {
                this.f4230a.add(packageName);
            }
        }
    }

    protected Throwable m5802a(Throwable t) {
        Throwable result = t;
        while (result.getCause() != null) {
            result = result.getCause();
        }
        return result;
    }

    protected StackTraceElement m5804b(Throwable t) {
        StackTraceElement[] elements = t.getStackTrace();
        if (elements == null || elements.length == 0) {
            return null;
        }
        for (StackTraceElement e : elements) {
            String className = e.getClassName();
            Iterator i$ = this.f4230a.iterator();
            while (i$.hasNext()) {
                if (className.startsWith((String) i$.next())) {
                    return e;
                }
            }
        }
        return elements[0];
    }

    protected String m5801a(Throwable cause, StackTraceElement element, String threadName) {
        StringBuilder descriptionBuilder = new StringBuilder();
        descriptionBuilder.append(cause.getClass().getSimpleName());
        if (element != null) {
            String[] classNameParts = element.getClassName().split("\\.");
            String className = "unknown";
            if (classNameParts != null && classNameParts.length > 0) {
                className = classNameParts[classNameParts.length - 1];
            }
            descriptionBuilder.append(String.format(" (@%s:%s)", new Object[]{className, element.getMethodName()}));
        }
        if (threadName != null) {
            descriptionBuilder.append(String.format(" {%s}", new Object[]{threadName}));
        }
        return descriptionBuilder.toString();
    }

    public String m5800a(String threadName, Throwable t) {
        return m5801a(m5802a(t), m5804b(m5802a(t)), threadName);
    }
}
