// . Create a class BankAccount with attributes like account number, balance, 
// account holder and name. Create an array of BankAccount objects to store 
// bank accounts. Implement methods to deposit money, withdraw money and 
// check balance.
import java.util.Scanner;
class Bank_Account{
    int acc_no;
    double balance;
    String name;
    double damount;
    double wamount;
    public void getDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter acc_no");
        acc_no=sc.nextInt();
        System.out.println("enter name");
        name=sc.next();
        System.out.println("enter balance");
        balance=sc.nextDouble();
        System.out.println("Enter amount to deposit ");
        damount=sc.nextDouble();
        deposit(damount);
        System.out.println("Enter amount to withdraw ");
        wamount=sc.nextDouble();
        withdraw(wamount);
        check_balance();
    }
     void deposit(double amount){
         balance+=amount;
         System.out.println("balance after deposit"+balance);
     }
     void withdraw(double amount){
        if(balance>=amount){
            balance-=amount;
        }else{
            System.out.println("Insufficient balance");
        }
         
         
     }
     void check_balance(){
         System.out.println("balance="+balance);
     }

}
public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array:");
        int n=sc.nextInt();
        Bank_Account [] arr=new Bank_Account[n];
        for(int i=0; i<n; i++){
            arr[i]=new Bank_Account();
            arr[i].getDetails();
        }
    }
}
