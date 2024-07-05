import java.util.Scanner;

public class SetIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the total number of intervals:");
        int n=sc.nextInt();
        int [][] intervals = new int[n][2];
        for(int i=0;i<n;i++){
            System.out.println("Enter both intervals:");
            intervals[i][0]=sc.nextInt();
            intervals[i][1]=sc.nextInt();
        }
        
        for(int i=0;i<n-1;i++){
            if(intervals[i+1][0]<=intervals[i][0] && intervals[i+1][0]>=intervals[i][1]){
                
            }
        }
    }
}
