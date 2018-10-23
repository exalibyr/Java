package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        PriorityAccount priorityAccount = new PriorityAccount(1, 100, "Jim", 0.05);
        priorityAccount.showInfo();
        FreeAccount freeAccount = new FreeAccount(2, 20, "John");
        freeAccount.showInfo();
        Transaction<PriorityAccount, FreeAccount> transaction = new Transaction<>(priorityAccount, freeAccount, 30);
        transaction.execute();
        Transaction<FreeAccount, PriorityAccount> transaction1 = new Transaction<>(freeAccount, priorityAccount, 10);
        transaction1.execute();

    }
}
