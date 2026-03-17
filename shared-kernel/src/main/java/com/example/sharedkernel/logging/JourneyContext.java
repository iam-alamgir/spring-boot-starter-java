package com.example.sharedkernel.logging;

import java.util.ArrayList;
import java.util.List;

public final class JourneyContext {
    private static final ThreadLocal<List<JourneyStep>> STEPS = ThreadLocal.withInitial(ArrayList::new);

    private JourneyContext() {}

    public static void addStep(String name, String detail) { STEPS.get().add(new JourneyStep(name, detail)); }
    public static List<JourneyStep> steps() { return List.copyOf(STEPS.get()); }
    public static void clear() { STEPS.remove(); }
}
