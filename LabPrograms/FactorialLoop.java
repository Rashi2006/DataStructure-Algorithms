import java.util.Scanner;
public class FactorialLoop{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        int pro=1;
        for(int i=2;i<=n;i++){
            pro*=i;
        }
        System.out.println(pro);
    }
}