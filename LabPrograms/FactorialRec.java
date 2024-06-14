import java.util.Scanner;
class Factorial{
     
     int pro(int i){
        if(i==0 || i==1){
            return 1;
        }else{
            return pro((i-1))*i;
        }
        
     }
}
public class FactorialRec{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=sc.nextInt();
       
        int ans=1;
        Factorial f = new Factorial();
        ans=f.pro(n);
        System.out.println(ans);
    }
}    
           
        