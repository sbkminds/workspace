package main.com.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Account {

    private Amount balance = Amount.of(BigDecimal.ZERO);
    private List<Statement> statements;

    public Account() {
        this.balance = Amount.of(BigDecimal.ZERO);
        this.statements = Collections.emptyList();
    }

    public Account(Amount balance, List<Statement> statements) {
        this.balance = balance;
        this.statements = statements;
    }

    public Account deposit(Amount amount) {
        if (amount.value().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        Amount newBalance = balance.plus(amount);
        List<Statement> newStatements = new ArrayList<>(statements);
        newStatements.add(new Statement(LocalDate.now(), amount, newBalance, TransactionType.DEPOSIT));
        return new Account(newBalance, newStatements);
    }

    public Account withdraw(Amount amount) {
        if (amount.value().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount.isGreaterThan(balance)) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        Amount newBalance = balance.minus(amount);
        List<Statement> newStatements = new ArrayList<>(statements);
        newStatements.add(new Statement(LocalDate.now(), amount, newBalance, TransactionType.WITHDRAWAL));
        return new Account(newBalance, newStatements);
    }

    public List<Statement> getStatements() {
        return Collections.unmodifiableList(statements);
    }
}
