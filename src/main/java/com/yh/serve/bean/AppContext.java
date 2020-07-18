package com.yh.serve.bean;

import java.util.Map;


public class AppContext {
    private static final ThreadLocal<Map<String,Object>> CONTEXT = ThreadLocal.withInitial(() -> null);

    public static Map<String,Object> get() {
        return CONTEXT.get();
    }

    public static void set(Map<String,Object> map) {
        CONTEXT.set(map);
    }

    public static void remove() {
        CONTEXT.remove();
    }
}
