package com.example.sharedkernel.context;

public final class CorrelationContext {
    private static final ThreadLocal<String> CID = new ThreadLocal<>();
    private CorrelationContext() {}
    public static void set(String id) { CID.set(id); }
    public static String get() { return CID.get(); }
    public static void clear() { CID.remove(); }
}
