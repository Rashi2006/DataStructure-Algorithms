import java.util.Scanner;
public class ChangeCaseInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("Enter the String :");
        String s = sc.nextLine();
        String r="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=65 && s.charAt(i)<=90){
                r+=(char)(s.charAt(i)+32);
            }
            else if(s.charAt(i)>=97 && s.charAt(i)<=122){
                r+=(char)(s.charAt(i)-32);
            }
        }
        System.out.println("s="+r);
    }
}
