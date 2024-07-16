
import java.util.*;

public class BinarySearch {
    public int search(int [] a ,int x){
        int left=0;
        int right=a.length-1;
        Arrays.sort(a);
           while(left<=right){
            int middle=(left+right)/2;
            System.out.println(middle);
              if(a[middle]==x){
                return middle;
              }else if(a[middle]<x){
                left=middle+1;
              }else{
                right=middle-1;
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
        
        BinarySearch ls = new BinarySearch();
        int r=ls.search(A, x);
        if(r!=-1){
            System.out.println("The index of "+x+"is="+r);
        }else{
            System.out.println("Index not found");
        }
        
    }
}
