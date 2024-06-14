import java.util.Scanner;
public class PatternSum{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n=sc.nextInt();
       
        int ans=0;
        for(int i=1;i<=n;i++){
            
            for(int j=1;j<=i;j++){
               ans+=j;
            }
        }
        System.out.println(ans);
    }
}