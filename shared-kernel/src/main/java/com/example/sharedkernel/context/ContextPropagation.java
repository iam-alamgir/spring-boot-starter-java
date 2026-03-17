package com.example.sharedkernel.context;

public final class ContextPropagation {
    private ContextPropagation() {}
    public static Runnable wrap(Runnable task) {
        final String cid = CorrelationContext.get();
        return () -> { CorrelationContext.set(cid); task.run(); CorrelationContext.clear(); };
    }
}
