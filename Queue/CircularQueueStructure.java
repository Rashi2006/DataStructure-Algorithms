import java.util.Scanner;
class MyCircularQueue{
    int front=-1;
    int rear=-1;
    int n;
    int [] arr;
    public MyCircularQueue(int n){
       this.n=n;
       arr=new int[n];
    }
    
    public void CQINSERT(int x){
       if((rear+1)%n==front){
            System.out.println(" QUEUE OVERFLOW--cannot be inserted");
            return;
       }
       rear=(rear+1)%n;
       arr[rear]=x;
       System.out.println("Element is inserted at:"+rear);
       if(front==-1){
          front=0;
       }
       return;

    }

    public int CQDELETE(){
        if(front==-1){
            System.out.println(" QUEUE UNDERFLOW--cannot be deleted");
            return -1;
        }
        int x=arr[front];
        if(front==rear){
            front=rear=-1;
            return x;
        }
        front=(front+1)%n;
        return x;
    }

    public void CQDISPLAY(){
        if(front==-1){
            System.out.println("Queue is empty");
            return;
        }
        if(front<=rear){
            for(int i=front;i<=rear;i++){
                System.out.print(arr[i]+" ");
            }
        }else{
            for(int i=front;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            for(int i=0;i<=rear;i++){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }

}
public class CircularQueueStructure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of queue:");
        int n=sc.nextInt();
        MyCircularQueue q = new  MyCircularQueue(n);

        System.out.println("Enter 1 to insert elements into queue");
        System.out.println("Enter 2 to remove elements from queue");
        System.out.println("Enter 3 to display elements of queue");
        System.out.println("Enter 4 to exit from the process");

        boolean isTheEnd = false;
        while (true) {
            System.out.println("Enter your choice:");
            int choice = sc.nextInt(); 
            switch ((choice)) {
                case 1: System.out.println("Enter the Element to be inserted:");
                        int x = sc.nextInt();
                        q.CQINSERT(x);
                        break;
                case 2: int a=q.CQDELETE();
                        if(a!=-1){
                            System.out.println("Deleted element is ="+a);
                        }  
                        break;    
                case 3:q.CQDISPLAY();
                        break;
                case 4:isTheEnd=true;
                        break;
                default:System.out.println("Invalid choice");
                        break;
            }
            if(isTheEnd){
                System.out.println("EXIT");
                break;
            }
        }
          
    }
}
