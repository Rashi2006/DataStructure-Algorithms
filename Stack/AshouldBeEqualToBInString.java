import java.util.Scanner;

public class AshouldBeEqualToBInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String :");
        String s = sc.next();
        int count = 0;
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            } else {
                flag++;
            }
        }
        if(count==flag){
            System.out.println("valid");
        }else{
            System.out.println("Invalid");
        }
        
    }
}