
package main.com.bank.adapter;

import main.com.bank.domain.Statement;

import java.util.List;

public class ConsoleStatementPrinter implements StatementPrinter {
    @Override
    public void print(List<Statement> statements) {
        System.out.println("Date       | Amount  | Balance | Type");
        for (Statement statement : statements) {
            StringBuilder sb = new StringBuilder();
            System.out.println(sb.append(statement.date())
                    .append("|")
                    .append(statement.amount().value())
                    .append("|")
                    .append(statement.balance().value())
                    .append("|")
                    .append(statement.type()));
        }
    }
}
