import java.util.Scanner;
public class Temperature {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 for Celsius and 2 for Fahrenheit:");
        int a=sc.nextInt();
        if(a==1){
            System.out.println("Enter the temperature in Celsius:");
            double c=sc.nextDouble();
            cToF(c);
            
        }else if(a==2){
            System.out.println("Enter the temperature in Fahrenheit:");
            double f=sc.nextDouble();
            fToC(f);
            
        }else{
            System.out.println("invalid input");
        }
    }
    static void cToF(double c) {
        double f=(c*9/5)+32;
        System.out.println("f="+f);
    }
    static void fToC(double f) {
        double c=(f-32)*5/9;
        System.out.println("c="+c);
    }
}
