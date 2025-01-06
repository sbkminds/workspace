package main.com.bank.application;

import main.com.bank.domain.Amount;
import main.com.bank.domain.Statement;

import java.util.List;

public interface BankService {
    void deposit(Amount amount);
    void withdraw(Amount amount);

    List<Statement> getStatements();
}
