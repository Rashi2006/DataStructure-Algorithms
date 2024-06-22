import java.util.Scanner;
class Arrs{
    int sum(int [] arr){
        int sum=0;
        for(int i=0; i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }

    double avg(int [] arr){
        int s=sum(arr);
        return s/arr.length;
    }

    int max(int [] arr){
        int max=arr[0];
        for(int i=1; i<arr.length;i++){
          if(arr[i]>max){
            max=arr[i];
          }
        }
        return max;
    }

    int min(int [] arr){
        int min=arr[0];
        for(int i=1; i<arr.length;i++){
          if(arr[i]<min){
            min=arr[i];
          }
        }
        return min;
    }
}
public class ArrayFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of an array:");
        int n = sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("arr["+i+"]=");
            arr[i]=sc.nextInt();
        }
        
        Arrs obj = new Arrs();
        System.err.println("sum="+obj.sum(arr));
        System.err.println("avj="+obj.avg(arr));
        System.err.println("max="+obj.max(arr));
        System.err.println("min="+obj.min(arr));
    }
}
