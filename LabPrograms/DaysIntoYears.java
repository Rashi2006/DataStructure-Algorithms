import java.util.Scanner;
public class DaysIntoYears{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of days:");
        int d=sc.nextInt();
        int y=0;
        int w=0;
        if(d>=365){
           y=d/365;
           d=d-(y*365);
           if(d>=7){
             w=d/7;
             d=d-(w*7);
           }
        }else{
            w=d/7;
            d=d-(w*7);
        }
        System.out.println(y+":"+w+":"+d);
    }
}