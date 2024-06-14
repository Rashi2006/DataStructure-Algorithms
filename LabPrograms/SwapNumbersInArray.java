import java.util.Scanner;
public class SwapNumbersInArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array:");
        int n=sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("arr["+i+"]");
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter the value of a");
        int a=sc.nextInt();
        
        System.out.println("Enter the value of b");
        int b=sc.nextInt();
        
        int i1=-1;
        int i2=-1;
        for(int i=0;i<n;i++){
           if(arr[i]==a){
             i1=i;
           }else if(arr[i]==b){
             i2=i;
           }
        }
        
        if(i1==-1 || i2==-1){
            System.out.println("Invalid Input");
        }else{
          int swap=arr[i1];
          arr[i1]=arr[i2];
          arr[i2]=swap;
        }

        for(int i=0;i<n;i++){
            System.out.println("arr["+i+"]="+arr[i]);
        }
        System.out.println("i1="+i1+"i2="+i2);
    }
}
