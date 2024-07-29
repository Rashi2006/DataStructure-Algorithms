
//  a menu driven program to implement following operations on the Queue 
// using an Array
// - ENQUEUE
// - DEQUEUE
// - DISPLAY
import java.util.Scanner;

class MyQueue {
    int front = -1;
    int rear = -1;
    int n;
    int[] arr;

    public MyQueue(int n) {
        arr = new int[n];
        this.n=n;
    }

    public void ENQUEUE(int x) {
        if (rear >= (n-1)) {
            System.out.println("Element cannot be inserted--QUEUE OVERFLOW!!");
            return;
        }
        rear = rear + 1;
        arr[rear] = x;
        if (front == -1) {
            front++;
        }
        return;
    }

    public int DEQUEUE() {
        if (front == -1) {
            System.out.println("Element cannot be deleted--QUEUE UNDERFLOW!!");
            return -1;
        }
        int x = arr[front];
        if (front == rear) {
            front = rear = -1;
            return x;
        }
        front = front + 1;
        return x;
    }

    public void DISPLAY() {
        if (front == -1) {
            System.out.println("QUEUE UNDERFLOW!!");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        return;
    }
}

public class QueueStructure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of queue:");
        int n=sc.nextInt();
        MyQueue q = new MyQueue(n);

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
                        q.ENQUEUE(x);
                        break;
                case 2: int a=q.DEQUEUE();
                        if(a!=-1){
                            System.out.println("Deleted element is ="+a);
                        }  
                        break;    
                case 3:q.DISPLAY();
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
