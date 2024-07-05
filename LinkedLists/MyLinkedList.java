import java.util.Scanner;

public class MyLinkedList {
    class Node {
        // Represents a node of a singly linked list
        int info;
        Node link;

        public Node(int data) {
            this.info = data;
            this.link = null;
        }
    }

    public Node first = null;

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

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        // If list is empty, newNode will be the first Node
        if (first == null) {
            first = newNode;
            return;
        }

        Node save = first;
        // traverse through the list till we find the last node
        while (save.link != null) {
            save = save.link;
        }
        // link poertion of last node will store the address of the newNode
        save.link = newNode;
    }

    public void insertAtAnyPosition(int i, int data) {
        Node newNode = new Node(data);
        if (first == null) {
            System.out.println("list is empty");
            return;
        }
        Node save = first;
        for (int j = 1; j < i - 1; j++) {
            if (save == null) {
                System.out.println("Index out of bounds");
                return;
            }
            save = save.link;
        }
        if (save != null) {
            newNode.link = save.link;
            save.link = newNode;
        }
    }

    public void deleteAtFirst() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        // pointer of the first node will be shifted to 2nd node
        first = first.link;
    }

    public void deleteAtLast() {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        // If only one node is present, set first to null
        if (first.link == null) {
            first = null;
            return;
        }
        Node save = first;
        // traverse till the second last node is found
        while (save.link.link != null) {
            save = save.link;
        }
        save.link = null;
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

    public void deleteAtAnyPosition(int p) {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }

        Node save = first;
        Node prev = null;

        if (save.info == p) {
            first = save.link;
            return;
        }
        while (save != null && save.info != p) {
            prev = save;
            save = save.link;
        }
        if (save == null) {
            System.out.println("Node not found");
            return;
        }
        prev.link = save.link;
    }

    public int sizeOfLinkedList(){
        if(first == null) {
            return 0;
        }
        int count=0;
        Node save=first;
        while(save!=null){
            count++;
            save=save.link;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyLinkedList li = new MyLinkedList();
        System.out.println("Please Enter 1 if you want to insert a node at 1st position in LL,");
        System.out.println("Please Enter 2 if you want to insert a node at last position in LL,");
        System.out.println("Please Enter 3 if you want to insert a node at any position in LL,");
        System.out.println("Please Enter 4 if you want to delete a node from 1st position in LL,");
        System.out.println("Please Enter 5 if you want to delete a node from last position in LL,");
        System.out.println("Please Enter 6 if you want to delete a node from any position in LL,");
        System.out.println("Please Enter 7 if you want to Display your linkedLIst,");
        System.out.println("Please Enter 8 if you want to get the size of linked list,");
        System.out.println("Please Enter 9 if you want to exit the process");

        boolean isTheEnd = false;
        while (true) {
            System.out.println("Enter your choice:");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter the number to be inserted at first:");
                    int num1 = sc.nextInt();
                    li.insertAtFirst(num1);
                    break;
                case 2:
                    System.out.println("Enter the number to be inserted at last:");
                    int num2 = sc.nextInt();
                    li.insertAtLast(num2);
                    break;
                case 3:
                    System.out.println("Enter the index :");
                    int i = sc.nextInt();
                    System.out.println("Enter the number to be inserted");
                    int num3 = sc.nextInt();
                    li.insertAtAnyPosition(i, num3);
                    break;
                case 4:
                    li.deleteAtFirst();
                    break;
                case 5:
                    li.deleteAtLast();
                    break;
                case 6:
                    System.out.println("Enter the node to be deleted:");
                    int pos = sc.nextInt();
                    li.deleteAtAnyPosition(pos);
                    break;
                case 7:
                    li.display();
                    break;
                case 8:
                    System.out.println("Size of sigly LL :"+li.sizeOfLinkedList());
                    break;
                case 9:
                    System.out.println("Exiting the process");
                    isTheEnd = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            if (isTheEnd) {
                break;
            }
        }
    }
}