package com.example.application.aspect;

import com.example.sharedkernel.logging.BusinessJourney;
import com.example.sharedkernel.logging.JourneyContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BusinessJourneyAspect {
    private static final Logger log = LoggerFactory.getLogger(BusinessJourneyAspect.class);

    @Around("@annotation(businessJourney)")
    public Object traceJourney(ProceedingJoinPoint pjp, BusinessJourney businessJourney) throws Throwable {
        JourneyContext.addStep("start", businessJourney.value());
        try {
            Object result = pjp.proceed();
            log.info("Journey {} completed with {} steps", businessJourney.value(), JourneyContext.steps().size());
            return result;
        } finally {
            JourneyContext.clear();
        }
    }
}
