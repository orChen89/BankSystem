package com.or;

import com.or.model.Client;

import java.util.ArrayList;
import java.util.List;

public class BankStatistics {

    public static void countMembers(){

        int amountOfMembers = BankSystem.viewClients().size() ;
        System.out.println("The amount of members in the bank are: " + amountOfMembers);
    }

    public static void richestClient(){

        for (Client client : BankSystem.viewClients()) {
            System.out.println("The richest client is: " + client.getName() + " with balance: "
                    +  client.getAccount().getBalance() + "$");
            return;
        }
    }

    public static void poorestClient(){

        List<Client> poorest = new ArrayList<>(BankSystem.viewClients());

        System.out.println("The poorest client is: " + poorest.get(poorest.size() - 1).getName() + " with balance: "
                + poorest.get(poorest.size() -1).getAccount().getBalance() + "$");

    }

    public static void totalBankBalance(){

        int totalBalanceSum = 0;
        for (Client client : BankSystem.instance.getClients()) {

            System.out.println(client);
            totalBalanceSum += client.getAccount().getBalance();

        }

        System.out.println("The total balance of the bank is: " + totalBalanceSum + "$");
    }
}
