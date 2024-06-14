import java.util.Scanner;
public class Prime{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        boolean isPrime=true;
        for(int i=2;i<Math.sqrt(n);i++){
            if(n%i==0){
                System.out.println("not Prime");
                isPrime=false;
                break;
            }
        }
        if(isPrime){
             System.out.println("Prime");
        }
    }
}