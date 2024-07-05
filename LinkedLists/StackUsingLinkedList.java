import java.util.Scanner;
public class StackUsingLinkedList {
    class Node {
        // Represents a node of a singly linked list
        int info;
        Node link;

        public Node(int data) {
            this.info = data;
            this.link = null;
        }
    }

    public Node top = null;

    public void push(int data) {
        // New Node created from availability stack
        Node newNode = new Node(data);

        // If list is empty , newNode will be the top Node
        if (top == null) {
            top = newNode;
            return;
        }

        // reference variable temp: which will store the address of the top node
        Node temp = top;
        // Make the newNode the top node
        top = newNode;
        // node temp will be connected after the top node
        top.link = temp;
    }

    public int pop() {
        if (top == null) {
            System.out.println("List is empty");
            return -1;
        }
        // pointer of the top node will be shifted to 2nd node
        int popped = top.info;
        // Now, the top node will be deleted from the stack
        top = top.link;
        return popped;
    }

    public int peep(int i) {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        Node temp = top;
        for (int j = 1; j < i; j++) {
            if (temp == null) {
                System.out.println("Index out of bounds");
                return -1;
            }
            temp = temp.link;
        }
        if (temp != null) {
            return temp.info;
        }
        return -1;
    }

    public void change(int i ,int x){
        if(top==null){
            System.out.println("Stack is empty");
            return ;
        }
        Node temp=top;
        for(int j=1;j<i;j++){
            if(temp==null){
                System.out.println("Index out of bounds");
                return;
            }
            temp=temp.link;
        }
        if(temp!=null){
            temp.info=x;
            return;
        }
    }

    public void display() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }
        Node save = top;
        while (save != null) {
            System.out.print(save.info + " ");
            save = save.link;
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        StackUsingLinkedList s = new StackUsingLinkedList();
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
                    if (popped != -1) {
                       System.out.println("Popped element is: " + popped);
                    } 
                    break;
                case 3:
                    System.out.println("Enter the index to see the element:");
                    int i = sc.nextInt();
                    int peep = s.peep(i);
                    if (peep != -1) {
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
    }
}
