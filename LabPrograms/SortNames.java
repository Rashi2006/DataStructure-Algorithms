import java.util.Scanner;
public class SortNames {
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the n:");
       int n=sc.nextInt();
       String []names=new String[n];
       for(int i=0;i<n;i++){
         System.out.println("names["+i+"]=");
         names[i]=sc.next();
       }
       int k=0;
       String temp;
       for(int i=0;i<n;i++){
         for(int j=i+1;j<n;j++){
            if(names[i].charAt(k)>names[j].charAt(k)){
                temp=names[i];
                names[i]=names[j];
                names[j]=temp;
            }else if(names[i].charAt(k)==(names[j].charAt(k))){
                for(int t=k+1;t<(Math.min(names[i].length(),names[j].length()));t++){
                    if(names[i].charAt(t)>names[j].charAt(t)){
                        temp=names[i];
                        names[i]=names[j];
                        names[j]=temp;
                        break;
                    }
                }
            }
         }
       }
       for(int i=0;i<n;i++){
        System.out.println(names[i]);
       }
    }
}
