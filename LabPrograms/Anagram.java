import java.util.Scanner;
public class Anagram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of words:");
        int n=sc.nextInt();
        System.out.println("ENter the words:");
        String[] str=new String[n];
        for(int i=0;i<n;i++){
            System.out.println("word"+i+"=");
            str[i]=sc.next();
        }
        int range=(n-1)-0+1;
        int rand=(int)(Math.random()*range);
        System.out.println("The randomly generated word is:"+str[rand]);
        System.out.println("Enter the anagram of given word:");
        String s=sc.next();
        boolean isFound=false;
        
        for(int i=0;i<str[rand].length();i++){
            isFound=false;
            for(int j=0;j<s.length();j++){
                if(str[rand].charAt(i)==s.charAt(j)){
                    isFound=true;
                }
            }
            if(!isFound){
                break;
            }
        }
        if(isFound){
            System.out.println("Anagram");
        }else{
            System.out.println("Not an anagram");
        }
    }
}
