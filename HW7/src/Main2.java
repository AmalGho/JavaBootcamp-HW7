import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {



        do {
            System.out.println("\n\nenter 1 for account summary."
            + "\nenter 2 to transfer money to another account."
            + "\nenter 3 to credit money from your account."
            + "\nenter 4 to debit money to your account."
            +"\nenter 5 to open an account."
            + "\nenter 6 to exit menu."
            + "\n\n select one option....");


            int option = userInput();


            if (option == 1) {
                getSummary();
            } else if (option == 2) {
                transferTo();
            } else if (option == 3) {
                credit();
            } else if (option == 4) {
                debit();
            } else if (option == 5) {
                openAccount();
            } else if (option == 6) {
                break;
            }else System.out.println("invalid entry..");

        }while(true);


    }




//    *********    controllers     **********


    public static int userInput() {
        Scanner input = new Scanner(System.in);
        int option = 0;
        try{
            option = input.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("** please you should enter number only :)");
        }
        return option;
    }


    public static void openAccount() {
        System.out.println("** OPEN an ACCOUNT **"
        + "\n\n enter your id ");
        String id = input.nextLine();
        System.out.println("enter your name ");
        String name = input.nextLine();
        Account acc = new Account(id, name);

        System.out.println("you have an account now..\n" + acc);
    }
    public static Account chooseAccount() throws Exception{

        Account ac1 = new Account("1", "amal", 100000);
        Account ac2 = new Account("2", "Nuha", 20000);
        Account ac3 = new Account("3", "Razan", 50000);
        Account ac4 = new Account("4", "Sara", 30000);

        Account acc = null;

        ArrayList<Account> list = new ArrayList<>();
        list.add(ac1);
        list.add(ac2);
        list.add(ac3);
        list.add(ac4);

        String name = input.nextLine();

        for (Account a : list) {
            if (a.getName().equalsIgnoreCase(name)) {
                acc = a;
            }
        }


        if (acc == null) {
            throw new Exception("no such account\n");
        }

        return acc;
    }


    public static void getSummary() {
        System.out.println("enter your name for account summary: ");
        Account acc = null;
        try {
            acc = chooseAccount();
            System.out.println(acc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void transferTo() {

        try{
            System.out.println("* enter your name to transfer money ");
            Account acc1 = chooseAccount();

            System.out.println("\nyour account " + acc1);

            System.out.println("\n* enter account name that you want to transfer money to ");
            Account acc2 = chooseAccount();

            System.out.println("\n* enter the money amount ");
            int amount = input.nextInt();
            input.nextLine();

            if (amount <= 0) {
                System.out.println("failed... you cannot debit negative amounts");
            } else if ( amount < acc1.getBalance() ) {
                acc1.transferTo(acc2, amount);
                System.out.println("\nsuccessful transaction.. \n ***  your balance now " + acc1.getBalance());
            } else System.out.println(acc1.getName() + " you do not have enough money to do this transaction...");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public  static void credit() {
        try {
            System.out.println("* enter your name to credit money ");
            Account acc = chooseAccount();

            System.out.println("\nyour account " + acc);

            System.out.println("\n* enter the money amount ");
            int amount = input.nextInt();
            input.nextLine();

            if (amount <= 0 ) {
                System.out.println("failed... you cannot debit negative amounts");
            }else if ( amount <= acc.getBalance()) {
                acc.credit(amount);
                System.out.println("\nsuccessful transaction.. \n ***  your balance now " + acc.getBalance());
            }else System.out.println(acc.getName() + " you do not have enough money to do this transaction...");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void debit() {
        try{
            System.out.println("* enter your name to debit money ");
            Account acc = chooseAccount();

            System.out.println("\nyour account " + acc);

            System.out.println("\n* enter the money amount ");
            int amount = input.nextInt();
            input.nextLine();

            if (amount >= 1) {
                acc.debit(amount);
                System.out.println("\nsuccessful transaction.. \n ***  your balance now " + acc.getBalance());
            }else System.out.println("failed... you cannot debit negative amounts");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
