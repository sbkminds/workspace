import main.com.bank.adapter.ConsoleStatementPrinter;
import main.com.bank.adapter.FileStatementPrinter;
import main.com.bank.application.BankService;
import main.com.bank.application.impl.BankServiceImpl;
import main.com.bank.domain.Amount;

import java.math.BigDecimal;


public class BankApp {
    public static void main(String[] args) {
        BankService service = new BankServiceImpl();
        ConsoleStatementPrinter consolePrinter = new ConsoleStatementPrinter();
        FileStatementPrinter filePrinter = new FileStatementPrinter("bank_statement.txt");

        service.deposit(Amount.of(BigDecimal.valueOf(1000)));
        service.withdraw(Amount.of(BigDecimal.valueOf(500)));
        service.deposit(Amount.of(BigDecimal.valueOf(200)));

        consolePrinter.print(service.getStatements());
        filePrinter.print(service.getStatements());

    }
}