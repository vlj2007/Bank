public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    // Синхронизированный метод для снятия денег
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " снимает " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " завершил снятие. Остаток: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " не хватает средств для снятия " + amount);
        }
    }

    // Синхронизированный метод для пополнения счета
    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " пополняет на " + amount);
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " завершил пополнение. Остаток: " + balance);
    }

    public int getBalance() {
        return balance;
    }



}
