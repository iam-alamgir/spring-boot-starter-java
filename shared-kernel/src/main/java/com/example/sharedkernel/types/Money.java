package com.example.sharedkernel.types;

import java.math.BigDecimal;
import java.util.Currency;

public record Money(BigDecimal amount, Currency currency) {
    public Money {
        if (amount == null || currency == null || amount.signum() < 0) {
            throw new IllegalArgumentException("invalid money");
        }
    }
}
