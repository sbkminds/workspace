package main.com.bank.application.impl;

import main.com.bank.domain.Account;
import main.com.bank.domain.Amount;
import main.com.bank.domain.Statement;
import main.com.bank.application.BankService;

import java.util.List;

public class BankServiceImpl implements BankService {
    private Account account;

    public BankServiceImpl() {
        this.account = new Account();
    }

    @Override
    public void deposit(Amount amount) {
        account = account.deposit(amount);
    }

    @Override
    public void withdraw(Amount amount) {
        account = account.withdraw(amount);
    }

    @Override
    public List<Statement> getStatements() {
        return account.getStatements();
    }
}
