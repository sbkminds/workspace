package main.com.bank.domain;

import java.math.BigDecimal;

public record Amount(BigDecimal value) {
    public static Amount of(BigDecimal value) {
        return new Amount(value);
    }

    public Amount plus(Amount other) {
        return new Amount(this.value.add(other.value));
    }

    public Amount minus(Amount other) {
        return new Amount(this.value.subtract(other.value));
    }

    public boolean isGreaterThan(Amount other) {
        return this.value.compareTo(other.value) > 0;
    }
}
