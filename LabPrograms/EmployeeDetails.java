import java.util.Scanner;
class Employee_Details{
    int Employee_ID;
    String name;
    String Desigantion;
    double salary;

    void printED(int Employee_ID , String name , String Desigantion , double salary){
        System.out.println("EmployeeId="+Employee_ID);
        System.out.println("Name="+name);
        System.out.println("Deesigantion="+Desigantion);
        System.out.println("salary="+salary);
    }
}
public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee_Details e = new Employee_Details();
        System.out.println("Enter the Employee_ID:");
        e.Employee_ID = sc.nextInt();
        System.out.println("Enter the name:");
        e.name = sc.next();
        System.out.println("Enter the desigantion:");
        e.Desigantion = sc.next();
        System.out.println("Enter the salary:");
        e.salary = sc.nextDouble();

        e.printED(e.Employee_ID,e.name,e.Desigantion,e.salary );
    }
}
