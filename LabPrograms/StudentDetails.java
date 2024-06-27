import java.util.Scanner;
class Student_detail{
    int enrollment;
    String name;
    int sem;
    double cpi;
    void getDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ENter enrollment no.:");
        enrollment=sc.nextInt();
        System.out.println("ENter name:");
        name=sc.next();
        System.out.println("ENter sem:");
        sem=sc.nextInt();
        System.out.println("ENter cpi:");
        cpi=sc.nextDouble();
        printsd(enrollment,name,sem,cpi);
    }
    void printsd(int enrollment, String name, int sem, double cpi){
         System.out.println("enrollment="+enrollment);
         System.out.println("name="+name);
         System.out.println("sem="+sem);
         System.out.println("cpi="+cpi);
    }
}
public class StudentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student_detail [] s = new Student_detail[5];
        for(int i=0;i<5;i++){
            s[i]=new Student_detail();
            s[i].getDetails();
        }
       
    }
}
