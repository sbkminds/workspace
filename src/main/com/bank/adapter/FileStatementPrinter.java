
package main.com.bank.adapter;

import main.com.bank.domain.Statement;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileStatementPrinter implements StatementPrinter {
    private final String filePath;

    public FileStatementPrinter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void print(List<Statement> statements) {
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            writer.println("Date       | Amount  | Balance | Type");
            for (Statement statement : statements) {
                writer.printf("%s | %s | %s | %s%n",
                        statement.date(),
                        statement.amount().value(),
                        statement.balance().value(),
                        statement.type());
            }
        } catch (IOException e) {
            System.err.println("Error writing statement to file: " + e.getMessage());
        }
    }
}
