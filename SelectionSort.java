import java.util.Scanner;
public class SelectionSort{
	public static void main(String [] args){

	    Scanner sc = new Scanner(System.in);
        System.out.println("ENter the size of an array to be sorted:");
        int n = sc.nextInt();

        System.out.println("Enter the array values:");
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("arr["+i+"]=");
            arr[i]=sc.nextInt();
        }
        
        
        int min_index;
        int min_Value;
        for(int i=0;i<(n);i++){
            min_index=i;
        	for(int j=i+1;j<n;j++){
        		if(arr[j]<arr[min_index]){
                    min_index=j;
        		}
        	}
        	
        	min_Value=arr[min_index];
        	arr[min_index]=arr[i];
        	arr[i]=min_Value;
        	
        }

        for(int i=0;i<n;i++){
    	    System.out.println("arr["+i+"]="+arr[i]);
        }
	}
}