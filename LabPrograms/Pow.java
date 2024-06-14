import java.util.Scanner;
public class Pow{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n=sc.nextInt();
        System.out.println("Enter the power:");
        int pow=sc.nextInt();
        int ans=1;
        for(int i=1;i<=pow;i++){
           ans=ans*n;
        }
        System.out.println(ans);
    }
}