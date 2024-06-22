import java.util.Scanner;
public class MergeTwoUnsortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array 1:");
        int n = sc.nextInt();
        int [] arr1=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("arr1["+i+"]=");
            arr1[i]=sc.nextInt();
        }
        System.out.println("Enter a size of an array 2:");
        int m = sc.nextInt();
        int [] arr2=new int[m];
        for(int i=0;i<m;i++){
            System.out.println("arr2["+i+"]=");
            arr2[i]=sc.nextInt();
        }
        
        int [] newarr = new int[arr1.length + arr2.length];
        int k=0;
        for(int i=0;i<newarr.length;i++){
           if(i<arr1.length){
            newarr[i]=arr1[i];
           }else{
            newarr[i]=arr2[k];
            k++;
           }
        }

        for(int i=0;i<newarr.length;i++){
            System.out.println("newarr["+i+"]="+newarr[i]);
        }
    }
}
