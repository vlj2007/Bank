public class Client {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000); // начальный баланс 1000

        // Создаем потоки для снятия денег
        Thread withdrawThread1 = new Thread(new WithdrawTask(bankAccount, 300), "Поток 1");
        Thread withdrawThread2 = new Thread(new WithdrawTask(bankAccount, 800), "Поток 2");

        // Создаем потоки для пополнения счета
        Thread depositThread1 = new Thread(new DepositTask(bankAccount, 500), "Поток 3");
        Thread depositThread2 = new Thread(new DepositTask(bankAccount, 400), "Поток 4");

        // Запускаем потоки
        withdrawThread1.start();
        withdrawThread2.start();
        depositThread1.start();
        depositThread2.start();

        try {
            // Ждем завершения всех потоков
            withdrawThread1.join();
            withdrawThread2.join();
            depositThread1.join();
            depositThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Конечный баланс: " + bankAccount.getBalance());
    }
}
