import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Employee employee;
        ArrayList<Employee> empList = new ArrayList<>();

        System.out.println("hello manager :) \n enter 3 employees information ");

        for (int i = 0; i < 3; i++) {
            try {

                System.out.println("enter employee id, name, salary ");
                employee = new Employee(input.nextLine(), input.nextLine(), input.nextInt());
                input.nextLine();

                empList.add(employee);

            }catch (InputMismatchException e) {
                System.out.println("invalid entry...");
            }
        }

        System.out.println("employees list: " + empList);


        System.out.println("\nPlease enter employee name you want to raised salary ");
        String empName = input.nextLine();

        for (Employee e : empList) {
            if (e.getName().equalsIgnoreCase(empName)) {
                System.out.println("enter raised percent ");
                int percent = input.nextInt();
                e.raisedSalary(percent);
                System.out.println(e.getName() + "'s salary after raised ...");
                System.out.println(e.getSalary());
            }
        }


    }

}