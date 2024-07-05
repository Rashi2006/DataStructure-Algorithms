import java.util.Scanner;

public class CheckTwoSinglyLinkedList {
    class Node {
        // Represents a node of a singly linked list
        int info;
        Node link;

        public Node(int data) {
            this.info = data;
            this.link = null;
        }
    }

    Node first = null;

    public void insertAtFirst(int data) {
        // New Node created from availability stack
        Node newNode = new Node(data);

        // If list is empty , newNode will be the first Node
        if (first == null) {
            first = newNode;
            return;
        }

        // reference variable save: which will store the address of the first node
        Node save = first;
        // Make the newNode the first node
        first = newNode;
        // node save will be connected after the first node
        first.link = save;
    }

    public void display() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        Node save = first;
        while (save != null) {
            System.out.print(save.info + " ");
            save = save.link;
        }
        System.out.println("");
    }

    public int sizeOfLinkedList() {
        if (first == null) {
            return 0;
        }
        int count = 0;
        Node save = first;
        while (save != null) {
            count++;
            save = save.link;
        }
        return count;
    }

    public boolean check(CheckTwoSinglyLinkedList L) {
        if (this.first == null && L.first == null) {
            return true;
        }
        Node save1 = this.first;
        Node save2 = L.first;
        while (save1 != null && save2 != null) {
            if(save1.info != save2.info) {
                return false;
            }
            save1 = save1.link;
            save2 = save2.link;
        }
        return true;
    }

 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the LinkedList 1 :");
        CheckTwoSinglyLinkedList list1 = new CheckTwoSinglyLinkedList();
        System.out.println("Please enter 1 if ypu want to enter elements,");
        System.out.println("Please enter 2 to display ll.");
        System.out.println("Please enter 3 if your insertion is completed.");
        while (true) {
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter the integer to add in the list:");
                int data = sc.nextInt();
                list1.insertAtFirst(data);
            } else if (choice == 2) {
                System.out.println("List 1:");
                list1.display();
            } else if (choice == 3) {
                System.out.println("LL 1 completed");
                break;
            } else {
                System.out.println("Inavlid input");
            }
        }

        System.out.println("Enter the LinkedList 2:");
        CheckTwoSinglyLinkedList list2 = new CheckTwoSinglyLinkedList();
        System.out.println("Please enter 1 if ypu want to enter elements,");
        System.out.println("Please enter 2 to display ll.");
        System.out.println("Please enter 3 if your insertion is completed.");
        while (true) {
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter the integer to add in the list:");
                int data = sc.nextInt();
                list2.insertAtFirst(data);
            } else if (choice == 2) {
                System.out.println("List 2:");
                list2.display();
            } else if (choice == 3) {
                System.out.println("LL 2 completed");
                break;
            } else {
                System.out.println("Inavlid input");
            }
        }

        if (list1.sizeOfLinkedList() != list2.sizeOfLinkedList()) {
            System.out.println(
                    "Both the LinkedList are not same as the total number of noeds in both linked list are different.");
        } else {
            if(list1.check(list2)){
                System.out.println("Both the LinkedList are same.");
            }else{
                System.out.println("Both the LinkedList are not same.");
            }
        }
    }
}
