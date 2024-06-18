import java.util.Scanner;
class Factorial{
    int factorial(int r){
        int pro=1;
        for(int i=2;i<=r;i++){
            pro*=i;
        }
        return pro;
    }
}
public class PascalsTriangle {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int n=sc.nextInt();
        Factorial f = new Factorial();
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<=(i);k++){
                int c=f.factorial(i);
                int r=f.factorial(k);
                int p=f.factorial(i-k);
                int ans=c/(p*r);
                System.out.print(ans+" ");
                
            }
            System.out.println();
        }
    }
}
