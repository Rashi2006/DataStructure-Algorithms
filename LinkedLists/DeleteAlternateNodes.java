import java.util.Scanner;

public class DeleteAlternateNodes {

    class Node {
        // Represents a node of a doubly linked list
        int info;
        Node lpter;
        Node rpter;

        public Node(int data) {
            this.info = data;
            this.lpter = null;
            this.rpter = null;
        }
    }

    public Node l = null;
    public Node r = null;

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        // If list is empty, newNode will be the first Node
        if (l == null && r == null) {
            l = r = newNode;
            return;
        }

        newNode.rpter = null;
        newNode.lpter = r;
        r.rpter = newNode;
        r = newNode;
    }

    public void display() {
        if (l == null && r == null) {
            System.out.println("List is empty");
            return;
        }
        Node save = l;
        System.out.print("null-->");
        while (save != null) {
            System.out.print(save.info + "-->");
            save = save.rpter;
        }
        System.out.println("null");
    }

    public int sizeOfLinkedList() {
        if (r == null && l == null) {
            return 0;
        }
        int count = 0;
        Node save = l;
        while (save != null) {
            count++;
            save = save.rpter;
        }
        return count;
    }

    public void deleteAlternates() {
        if (l == null) {
            System.out.println("List is empty");
            return;
        }
        int count = 1;
        Node save = l;
        while (save != null) {
            if (count % 2 != 0) {
                if (save == l) {
                    l = l.rpter;
                    if (l != null) {
                        l.lpter = null;
                    }
                    save = l;
                } else if (save == r) {
                    r = r.lpter;
                    if (r != null) {
                        r.rpter = null;
                    }
                    save = null;
                } else {
                    save.lpter.rpter = save.rpter;
                    if (save.rpter != null) {
                        save.rpter.lpter = save.lpter;
                    }
                    save = save.rpter;
                }
            } else {
                save = save.rpter;
            }
            count++;
        }
        display();
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DeleteAlternateNodes list = new DeleteAlternateNodes();

        System.out.println("Enter 1 for inserting numbers into linked list,");
        System.out.println("Enter 2 if you want to see your LL,");
        System.out.println("Enter 3 to delete the alternate Node from the Linked List .");

        boolean istheEnd = false;
        while (true) {
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to be inserted:");
                    int n = sc.nextInt();
                    list.insertAtLast(n);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    list.deleteAlternates();
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
