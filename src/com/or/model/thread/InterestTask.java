package com.or.model.thread;

import com.or.BankSystem;
import com.or.model.Client;

public class InterestTask implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread() + " has started to run");
         while(true){

             if(BankSystem.instance.getClients().size() >= 1){
                 for (Client client : BankSystem.instance.getClients()) {
                     double prevBalance = client.getAccount().getBalance();
                     System.out.println("Current balance: " + prevBalance + "$");

                     client.getAccount().setBalance(prevBalance - (prevBalance * client.getInterestRate()));
                     System.out.println(client.getName() + " with id: " + client.getId()
                             + " with the updated balance: " + client.getAccount().getBalance() + "$");
                     System.out.println(Thread.currentThread() + " went to sleep");
                }
             }
             try {
                 Thread.sleep(60000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
}

