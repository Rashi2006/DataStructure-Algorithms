import java.util.Scanner;
public class DuplicateOrNot {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array:");
        int n=sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("arr["+i+"]");
            arr[i]=sc.nextInt();
        }
        boolean isFound=false;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
               if(arr[i]==arr[j]){
                  isFound=true;
                  System.out.println("contains Duplicate");
                  break;
                }
            }
            if(isFound){
                break;
            }
        }
        if(!isFound){
            System.out.println("Does not contain duplicate");
        }
}
}