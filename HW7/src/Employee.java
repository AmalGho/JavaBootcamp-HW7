public class Employee {



    private String id;
    private String name;
    private int salary;


    Employee(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return getSalary() * 12;
    }

    public  int raisedSalary(int percent) {
        setSalary(getSalary() + ((getSalary() * percent) / 100));
        return salary;
    }


    public String toString(){
        return "** the employee " + getName() + " with id " + getId()
                + " \n the salary " + getSalary()
                + " \n the annual salary " + getAnnualSalary()
                +"\n\n";
    }
}
