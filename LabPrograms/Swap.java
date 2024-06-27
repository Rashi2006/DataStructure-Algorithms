import java.util.Scanner;
public class Swap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a:");
        int a=sc.nextInt();
        System.out.println("Enter the value of b:");
        int b=sc.nextInt();
        swap(a,b);
    }
    static void swap(int a,int b){
        int s;
        s=a;
        a=b;
        b=s;
        System.out.println("a="+a+"b="+b);
    }
}
