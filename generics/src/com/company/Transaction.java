package com.company;

public class Transaction<T extends Account, S extends Account> {

    private T sender;
    private S receiver;
    private double value;

    public Transaction(T sender, S receiver, double value) {
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
    }

    public void execute(){
        sender.setBalance(sender.getBalance() - value);
        if(sender instanceof PriorityAccount){
            sender.setBalance(sender.getBalance() + value * ((PriorityAccount) sender).getCashbackValue());
        }
        receiver.setBalance(receiver.getBalance() + value);
        System.out.println(value + " sent");
        sender.showInfo();
        receiver.showInfo();
    }
}
