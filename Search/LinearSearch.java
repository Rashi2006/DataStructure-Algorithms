
import java.util.Scanner;
public class LinearSearch {
    public int search(int [] a , int x){
         for(int i = 0; i < a.length; i++){
            if(a[i] == x){
                return i;
            }
         }
         return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array:");
        int n=sc.nextInt();
        
        int [] A = new int[n];
        for(int i=0; i<n; i++) {
            System.out.println("A["+i+"]=");
            A[i]=sc.nextInt();
        }

        System.out.println("Enter the element to be searched:");
        int x=sc.nextInt();

        LinearSearch ls = new LinearSearch();
        int r=ls.search(A,x);
        if(r!=-1){
            System.out.println("The index of "+x+"is="+r);
        }else{
            System.out.println("Index not found");
        }
        
    }
}
