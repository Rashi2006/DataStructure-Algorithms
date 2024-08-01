
import java.util.Scanner;

class MyDQueue {
    int front = -1;
    int rear = -1;
    int n;
    int[] arr;

    public MyDQueue(int n) {
        arr = new int[n];
        this.n = n;
    }

    public void DQINSERT_REAR(int x) {
        if (rear >= (n - 1)) {
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

    public int DQDELETE_FRONT() {
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

    public void DQINSERT_FRONT(int x) {
        if (front == 0) {
            System.out.println("Element cannot be inserted at first--QUEUE OVERFLOW!!");
            return;
        }

        if (front == -1) {
            front++;
            rear++;
        } else {
            front = front - 1;
        }
        arr[front] = x;
        return;
    }

    public int DQDELETE_REAR() {
        if (rear == -1) {
            System.out.println("Element cannot be deleted from rear--QUEUE UNDERFLOW!!");
            return -1;
        }
        int x = arr[rear];
        if (front == rear) {
            front = rear = -1;
            return x;
        }
        rear--;
        return x;
    }

    public void DISPLAY_1() {
        if (front == -1) {
            System.out.println("QUEUE UNDERFLOW!!");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }
}

public class DQueueStructure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of queue:");
        int n = sc.nextInt();
        MyDQueue q = new MyDQueue(n);

        System.out.println("Enter 1 to insert elements from rear into queue");
        System.out.println("Enter 2 to remove elements from front of queue");
        System.out.println("Enter 3 to insert elements from front into queue");
        System.out.println("Enter 4 to remove elements from rear of queue");
        System.out.println("Enter 5 to display elements of queue");
        System.out.println("Enter 6 to exit from the process");

        boolean isTheEnd = false;
        while (true) {
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch ((choice)) {
                case 1:
                    System.out.println("Enter the Element to be inserted:");
                    int x = sc.nextInt();
                    q.DQINSERT_REAR(x);
                    break;
                case 2:
                    int a = q.DQDELETE_FRONT();
                    if (a != -1) {
                        System.out.println("Deleted element is =" + a);
                    }
                    break;
                case 3:
                    System.out.println("Enter the Element to be inserted:");
                    x = sc.nextInt();
                    q.DQINSERT_FRONT(x);
                    break;
                case 4:
                    a = q.DQDELETE_REAR();
                    if (a != -1) {
                        System.out.println("Deleted element is =" + a);
                    }
                    break;
                case 5:
                    q.DISPLAY_1();
                    break;
                case 6:
                    isTheEnd = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            if (isTheEnd) {
                System.out.println("EXIT");
                break;
            }
        }

    }
}
