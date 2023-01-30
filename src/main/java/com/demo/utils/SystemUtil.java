package com.demo.utils;

import java.lang.reflect.Field;
import java.util.Map;

public class SystemUtil {
   
    public static void setEnv(String key, String value) {
        try {
            Map<String, String> env = System.getenv();
            Class<?> classInstance = env.getClass();
            Field field = classInstance.getDeclaredField("m");
            field.setAccessible(true);
            Map<String, String> writableEnv = (Map<String, String>) field.get(env);
            writableEnv.put(key, value);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to set environment variable", e);
        }
    }
    
}
