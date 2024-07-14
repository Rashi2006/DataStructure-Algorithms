import java.util.Scanner;

public class SwapTwoConsecutiveNodes {
    class Node {
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

    public void swap() {
        int n = sizeOfLinkedList();
        if (n % 2 == 0) {
            Node save = first;
            Node prev = null;

            while (save != null) {
                Node temp = save.link;
                save.link = temp.link;
                temp.link = save;
                if (prev == null) {
                    first = temp;
                } else {
                    prev.link = temp;
                }
                prev = save;
                save = save.link;
            }
        } else {
            Node save = first;
            Node prev = null;

            while (save.link != null) {
                Node temp = save.link;
                save.link = temp.link;
                temp.link = save;
                if (prev == null) {
                    first = temp;
                } else {
                    prev.link = temp;
                }
                prev = save;
                save = save.link;
            }
        }

        display();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SwapTwoConsecutiveNodes list = new SwapTwoConsecutiveNodes();

        System.out.println("Enter 1 for inserting nubers into linked list,");
        System.out.println("Enter 2 if you want to see your LL,");
        System.out.println("Enter 3 to perform swap operation in your Linked List .");

        boolean istheEnd = false;
        while (true) {
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to be inserted:");
                    int n = sc.nextInt();
                    list.insertAtFirst(n);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    list.swap();
                    istheEnd = true;
                    break;
                default:
                    System.out.println("invalid choice");
            }
            if (istheEnd) {
                break;
            }
        }
    }
}
