import java.util.Scanner;

class MyStack {
    int top = -1;
    int n;
    int[] arr;

    MyStack(int n) {
        this.n = n;
        arr = new int[n];
    }

    void push(int x) {
        if (top >= (n-1)) {
            System.out.println("Stack Overflow");
        } else {
            top = top + 1;
            arr[top] = x;
            System.out.println("Element is pushed successfully");
        }
        return;
    }

    int pop() {
        if (top == -1) {
            return -1;
        } else {
            top = top - 1;
            return arr[top+1];
        }
    }

    int peep(int i) {
        if ((top - i + 1) <=0 || i<=0) {
            return -1;
        } else {
            return arr[top - i + 1];
        }
    }

    void change(int i, int x) {
        if ((top - i + 1) <=0 || i<=0) {
            System.out.println("Invalid Index");
            return;
        } else {
            arr[top - i + 1] = x;
            System.out.println("Your changes are done successfully");
            return;
        }
    }

    void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i] + " ");
        }
        return;
    }
}

public class StackStructure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of stack:");
        int n = sc.nextInt();
        MyStack s = new MyStack(n);
        System.out.println("Enter 1 if you want to push element in the stack,");
        System.out.println("Enter 2 if you want to delete element from the stack,");
        System.out.println("Enter 3 if you want to see the any element of the stack,");
        System.out.println("Enter 4 if you want to change any element of the stack,");
        System.out.println("Enter 5 if you want to display the stack");
        System.out.println("Enter 6 if you don't have any further changes");

        boolean isTheEnd = false;
        while (true) {
            System.out.println("Please enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to be pushed:");
                    int x = sc.nextInt();
                    s.push(x);
                    break;
                case 2:
                    int popped = s.pop();
                    if (popped == -1) {
                        System.out.println("Stack underflow");
                    } else {
                        System.out.println("Popped element is: " + popped);
                    }
                    break;
                case 3:
                    System.out.println("Enter the index to see the element:");
                    int i = sc.nextInt();
                    int peep = s.peep(i);
                    if (peep == -1) {
                        System.out.println("Invalid Index");
                    } else {
                        System.out.println("Element at index " + i + " is: " + peep);
                    }
                    break;
                case 4:
                    System.out.println("Enter the index and the new element to change:");
                    System.out.println("i=");
                    i = sc.nextInt();
                    System.out.println("x=");
                    x = sc.nextInt();
                    s.change(i, x);
                    break;
                case 5:
                    s.display();
                    break;
                case 6:
                    isTheEnd = true;
                    break;
                default:
                    System.out.println("Please Enter valid choice");
            }
            if (isTheEnd) {
                break;
            }
        }
        System.out.println("Program Terminates");
        sc.close();
    }
}