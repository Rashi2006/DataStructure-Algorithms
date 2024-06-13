import java.util.Scanner;
public class SecondsToHours{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sec:");
        int s=sc.nextInt();
        int h=0;
        int m=0;
        if(s>=3600){
            h=s/3600;
            s=s-(h*3600);
            if(s>=60){
               m=s/60;
               s=s-(m*60);
            }
        }else{
           m=s/60;
           s=s-60;
        }
        System.out.println(h+":"+m+":"+s);
    }
}