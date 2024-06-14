import java.util.Scanner;
public class BubbleSort{
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

    Boolean isFound=false;
    int swap;
    for(int i=0;i<(n-1);i++){
    	isFound=false;
        for(int j=0;j<(n-1);j++){
            if(arr[j]>arr[j+1]){
               swap=arr[j];
               arr[j]=arr[j+1];
               arr[j+1]=swap;
               isFound=true;
            }
        }
        if(!isFound){
        	break;
        }
    }

    for(int i=0;i<n;i++){
    	System.out.println("arr["+i+"]="+arr[i]);
    }
	}
}