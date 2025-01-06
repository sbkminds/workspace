package main.com.bank.domain;

import java.time.LocalDate;

public record Statement(LocalDate date, Amount amount, Amount balance, TransactionType type) {
}
