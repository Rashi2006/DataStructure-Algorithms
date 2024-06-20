import java.util.Scanner;
public class DeleteFromSortedArray {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array:");
        int n = sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("arr["+i+"]=");
            arr[i]=sc.nextInt();
        }
        
        System.out.println("Enter the number to be deleted:");
        int e=sc.nextInt();

        int [] newarr = new int[arr.length - 1];
        int k=0;

        for(int i=0;i<arr.length;i++){
            if(e==arr[i]){
                continue;
            }else{
                newarr[k]=arr[i];
                k++;
            }
        }

        for(int i=0;i<newarr.length;i++){
            System.out.println("newarr["+i+"]="+newarr[i]);
        }
    }
}
