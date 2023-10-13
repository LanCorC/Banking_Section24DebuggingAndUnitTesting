import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private static int count;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("This executes once, before any tests. Count = " + count++);
    }
    @BeforeEach
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }


    @Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @Test
    void withdraw_branch() {
        double balance = account.withdraw(600, true);
        assertEquals(400.00, balance,0);
    }

    @Test
    void withdraw_notBranch() {
        assertThrows(IllegalArgumentException.class, () -> {
            double withdraw = account.withdraw(600, false);
        });
    }

    @Test
    void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);

    }

    @Test
    public void isChecking_true() {
            assertTrue(account.isChecking());
    }

//    @Test
//    public void isChecking_false() {
//        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.SAVINGS);
//        assertFalse(account.isChecking());
//    }

    @AfterAll
    public static void afterAll() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }
    @AfterEach
    public void tearDown() {
        System.out.println("Count = " + count++);
    }


}