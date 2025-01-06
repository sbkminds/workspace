
package test.com.bank.application;


import main.com.bank.application.BankService;
import main.com.bank.application.impl.BankServiceImpl;
import main.com.bank.domain.Amount;
import main.com.bank.domain.Statement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankServiceTest {

    private BankService bankService;

    @BeforeEach
    void setUp() {
        bankService = new BankServiceImpl();
    }

    @Test
    void us1_deposit_shouldIncreaseBalance_whenAmountIsPositive() {
        // Given
        Amount depositAmount = Amount.of(BigDecimal.valueOf(1000));

        // When
        bankService.deposit(depositAmount);

        // Then
        List<Statement> statements = bankService.getStatements();
        assertEquals(1, statements.size());
        assertEquals(depositAmount, statements.get(0).amount());
    }

    @Test
    void us2_withdraw_shouldDecreaseBalance_whenSufficientBalance() {
        // Given
        Amount depositAmount = Amount.of(BigDecimal.valueOf(1000));
        Amount withdrawAmount = Amount.of(BigDecimal.valueOf(500));
        bankService.deposit(depositAmount);

        // When
        bankService.withdraw(withdrawAmount);

        // Then
        List<Statement> statements = bankService.getStatements();
        assertEquals(2, statements.size());
        assertEquals(withdrawAmount, statements.get(1).amount());
    }

    @Test
    void withdraw_shouldThrowException_whenInsufficientBalance() {
        // Given
        Amount withdrawAmount = Amount.of(BigDecimal.valueOf(1000));

        // When / Then
        assertThrows(IllegalArgumentException.class, () -> bankService.withdraw(withdrawAmount));
    }
}
