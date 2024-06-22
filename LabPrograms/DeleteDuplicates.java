import java.util.Scanner;
public class DeleteDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array:");
        int n = sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("arr["+i+"]=");
            arr[i]=sc.nextInt();
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                continue;
            }
            for(int j=i+1;j<n;j++){
               if(arr[i]==arr[j]){
                arr[j]=0;
                count++;
               }
            }
        }
        int [] newarr=new int[n-count];
        int k=0;
        for(int i=0;i<n;i++){
           if(arr[i]==0){
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
