import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void deposit() {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.CHECKING);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @Test
    void withdraw() {
        fail("This test has yet to be implemented");
    }

    @Test
    void getBalance_deposit() {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.CHECKING);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);

    }

    @Test
    void getBalance_withdraw() {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.CHECKING);
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);

    }

    @Test
    public void isChecking_true() {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.CHECKING);
            assertTrue(account.isChecking());
    }

    @Test
    public void isChecking_false() {
        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.SAVINGS);
        assertFalse(account.isChecking());
    }

}