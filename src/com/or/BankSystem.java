package com.or;

import com.or.model.*;
import com.or.model.exceptions.DeleteException;
import com.or.model.exceptions.WithdrawException;
import com.or.model.thread.InterestTask;

import java.util.*;

public class BankSystem {

    public static final BankSystem instance = new BankSystem();

    private InterestTask task;
    public static final Set<Client> clients = new HashSet<>();
    private static final Scanner scanner = new Scanner(System.in);

  private BankSystem(){}

  public void startSystem() {

      this.task = new InterestTask();

      Thread thread = new Thread(this.task);
      thread.start();

      while (true) {

          System.out.println("Hello Expensive friend! Please choose between the following: ");
          menu();
          int userChoice = scanner.nextInt();

          switch (userChoice) {
              case 1:
                  addClient();
                  break;

              case 2:
                  deleteClient();
                  break;

              case 3:
                  withdraw();
                  break;

              case 4:
                  deposit();
                  break;

              case 5:
                  System.out.println(viewClients());
                  break;

              case 6:
                  BankStatistics.richestClient();
                  break;

              case 7:
                  BankStatistics.poorestClient();
                  break;

              case 8:
                  BankStatistics.totalBankBalance();
                  break;

              case 9:
                  System.out.println("Goodbye!");
                  thread.stop();
                  return;
          }
      }
  }

  public void deleteClient() {


      System.out.println("Please enter the id number of the client you wish to delete: ");
      int id = scanner.nextInt();

        for (Client client : clients) {

          if (client.getId() == id && client.getAccount().getBalance() == 0) {
              try {
                  throw new DeleteException(new Date());
              } catch (DeleteException e) {
                  e.printStackTrace();
              }
          } else if (client.getAccount().getBalance() > 0) {

              clients.removeIf((x) -> x.getId() == id);

              clients.forEach(System.out::println);
              return;
          }
      }
  }

    private void deposit() {

        System.out.println("Please enter the id number of the client: ");
        int id = scanner.nextInt();

        System.out.println("Please enter the amount of money you wish to deposit: ");
        int amount = scanner.nextInt();

        for (Client client : clients) {

            if (client.getId() == id) {
                double firstBalance = client.getAccount().getBalance();
                client.getAccount().setBalance(client.getAccount().getBalance() + amount);
                System.out.println(client.getName() + " has deposited: " + amount + "$" + " to his total balance of: "
                        + firstBalance + "$" + " and now his total balance is: " + client.getAccount().getBalance() + "$");
                return;
            }
        }
    }

  private void withdraw() {

      System.out.println("Please enter the id number of the client: ");
      int id = scanner.nextInt();

      System.out.println("Please enter the amount of money you wish to withdraw: ");
      long amount = scanner.nextInt();

      for (Client client : clients) {

          if (client.getId() == id && client.getAccount().getBalance() < amount) {
             try {
                    throw new WithdrawException(new Date());
             } catch (WithdrawException e) {
                      e.printStackTrace();
                  }
              } else if (client.getId() == id && amount <= client.getAccount().getBalance()) {
                  double firstBalance = client.getAccount().getBalance();
                  client.getAccount().setBalance(client.getAccount().getBalance() - amount);
                  System.out.println(client.getName() + " has withdrawal: " + amount + "$" + " from total balance of: "
                      + firstBalance + "$" + " and now his total balance is: " + client.getAccount().getBalance() + "$");
                  return;
              }
          }
      }


  private void menu() {

          System.out.println("1 - Add a new client " + "\n" + "2 - Delete a client " + "\n" +
          "3 - Withdraw money " + "\n" + "4 - Deposit money " + "\n" + "5 - View all clients " + "\n" +
          "6 - Show the richest client " + "\n" + "7 - Show the poorest client " + "\n" +
          "8 - Show the full balance in the bank" + "\n" + "9 - Exit");
          System.out.println();

      }

  private void addClient() {

          System.out.println("In order to add a new client please choose between regular client or VIP client: ");
          System.out.println("1 - Regular client | 2 - VIP client");
          int choice = scanner.nextInt();

          if (choice == 1) {

             createRegularClient();

          } else if (choice == 2) {

              createVipClient();
          }
      }


  public void createRegularClient() {

      RegularClient regularClient = new RegularClient();

      regularClient.setId(regularClient.getId());
      regularClient.setName(regularClient.getName());
      regularClient.setAge(getRandomNumberScore(16, 120));
      regularClient.setInterestRate(0.05f);
      regularClient.setAccount(new Account());

      clients.add(regularClient);

    }

    public void createVipClient() {

        VipClient vipClient = new VipClient();

        vipClient.setId(vipClient.getId());
        vipClient.setName("Client " + vipClient.getName());
        vipClient.setAge(getRandomNumberScore(16, 120));
        vipClient.setInterestRate(0.10f);
        vipClient.setAccount(new Account());

       clients.add(vipClient);

    }

    public static Set<Client> viewClients() {

        Set<Client> sortedClients = new TreeSet<>((o1, o2) ->
                Double.compare(o2.getAccount().getBalance(), o1.getAccount().getBalance())) {
        };

        sortedClients.addAll(clients);

        return sortedClients;

        }

    private static int getRandomNumberScore(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }

    public Set<Client> getClients() {
        return clients;
    }
}
