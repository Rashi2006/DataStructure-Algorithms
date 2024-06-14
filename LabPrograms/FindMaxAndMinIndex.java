import java.util.Scanner;
public class FindMaxAndMinIndex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array:");
        int n=sc.nextInt();
        int [] arr=new int[n];5
        for(int i=0;i<n;i++){
            System.out.println("arr["+i+"]");
            arr[i]=sc.nextInt();
        }
        int max=arr[0];
        int mi=0;
        int min=arr[0];
        int MI=0;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                mi=i;
            }
            if(arr[i]<min){
                min=arr[i];
                MI=i;
            }
        }
        System.out.println("Max index="+mi);
        System.out.println("Min index="+MI);
    }
}
