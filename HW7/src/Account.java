public class Account {

    private String id;
    private String name;
    private int balance = 0;

    Account (String id, String name) {
        this.id = id;
        this.name = name;
    }

    Account (String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }



    public int credit(int amount) {
        setBalance(getBalance() - amount);
        return balance;
    }

    public int debit(int amount) {
        setBalance(getBalance() + amount);
        return balance;
    }

    public int transferTo(Account account, int amount) {
        account.setBalance(account.getBalance() + amount);
        setBalance(getBalance() - amount);
        return balance;
    }

    public String toString() {
        return "name: " + getName()
                + " - " + getId()
                + "\n balance: " + getBalance();
    }
}
