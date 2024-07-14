// . Given a set of time intervals in any order, our task is to merge all overlapping 
// intervals into one and output the result which should have only mutually 
// exclusive intervals 
//  Input: Intervals = {{1,3},{2,4},{6,8},{9,10}} 
// o Output: {{1, 4}, {6, 8}, {9, 10}} 
// o Explanation: Given intervals: [1,3],[2,4],[6,8],[9,10], we have only 
// two overlapping intervals here,[1,3] and [2,4]. Therefore we will 
// merge these two and return [1,4],[6,8], [9,10] 
//  Input: Intervals = {{6,8},{1,9},{2,4},{4,7}} 
// o Output: {{1, 9}}
import java.util.Scanner;
class MyStack {
    int top = -1;
    int n;
    int[][] arr;

    MyStack(int n) {
        this.n = n;
        arr = new int[n][2];
    }

    void push(int x , int y) {
        if (top >= (n-1)) {
            System.out.println("Stack Overflow");
        } else {
            top = top + 1;
            arr[top][0] = x;
            arr[top][1] = y;
            System.out.println("Element is pushed successfully");
        }
        return;
    }

    int [] pop() {
        if (top == -1) {
            return new int[]{-1,-1};
        } else {
            top = top - 1;
            return arr[top+1];
        }
    }

    void change(int i, int x , int y) {
        if ((top - i + 1) <=0 || i<=0) {
            System.out.println("Invalid Index");
            return;
        } else {
            arr[top - i + 1][0] = x;
            arr[top - i + 1][0] = y;
            // System.out.println("Your changes are done successfully");
            return;
        }
    }

    void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i][0] + " " +arr[i][1]);
        }
        return;
    }
}
public class SetIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the total number of intervals:");
        int n=sc.nextInt();
        int [][] intervals = new int[n][2];
        for(int i=0;i<n;i++){
            System.out.println("Enter both intervals when i="+i+":");
            intervals[i][0]=sc.nextInt();
            intervals[i][1]=sc.nextInt();
        }
         
        MyStack st = new MyStack(n);;

        for(int i=0;i<n-1;i++){
            if((intervals[i][1]<intervals[i+1][0]) ){
                st.push(intervals[i][0],intervals[i][1]);
            }else if(intervals[i][1]<intervals[i+1][1]){
                
                st.push(intervals[i+1][0],intervals[i+1][1]);
                
            }else{
                st.push(intervals[i+1][0],intervals[i+1][1]);
            }
        }
    }
}
