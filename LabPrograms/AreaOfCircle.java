import java.util.Scanner;
public class AreaOfCircle{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of circle");
        double r=sc.nextDouble();
        System.out.println("area="+(Math.pow(r,2)*3.14));
    }
}