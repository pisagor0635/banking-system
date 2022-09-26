package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        // complete the function
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
        // complete the function
        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        // complete the function
        Long accountNumber = Long.valueOf(company.getIdNumber());
        if (accounts.get(accountNumber) != null) {
            accountNumber = Long.valueOf(accounts.keySet().size() + 1);
        }
        Account account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return account.getAccountNumber();
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        // complete the function
        Long accountNumber = Long.valueOf(person.getIdNumber());
        if (accounts.get(accountNumber) != null) {
            accountNumber = Long.valueOf(accounts.keySet().size() + 1);
        }
        Account account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, account);
        return account.getAccountNumber();
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        // complete the function
		return getAccount(accountNumber).validatePin(pin);
    }

    public double getBalance(Long accountNumber) {
        // complete the function
		return getAccount(accountNumber).getBalance();
    }

    public void credit(Long accountNumber, double amount) {
        // complete the function
		getAccount(accountNumber).creditAccount(amount);
	}

    public boolean debit(Long accountNumber, double amount) {
        // complete the function
		return getAccount(accountNumber).debitAccount(amount);
    }
}
