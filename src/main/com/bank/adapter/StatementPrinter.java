
package main.com.bank.adapter;


import main.com.bank.domain.Statement;

import java.util.List;

public interface StatementPrinter {
    void print(List<Statement> statements);
}
