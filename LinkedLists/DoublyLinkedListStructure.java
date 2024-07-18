import java.util.Scanner;

public class DoublyLinkedListStructure {
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

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);

        if (l == null && r == null) {
            l = r = newNode;
            return;
        }
        newNode.lpter = null;
        newNode.rpter = l;
        l.lpter = newNode;
        l = newNode;
    }

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

    public void insertAtAnyPosition(int i, int data) {
        Node newNode = new Node(data);
        if (l == null && r == null && i != 1) {
            System.out.println("List is empty , cannot be inserted at given index");
            return;
        } else if (l == null && r == null) {
            l = r = newNode;
            return;
        }
        if (i == 1) {
            newNode.lpter = null;
            newNode.rpter = l;
            l.lpter = newNode;
            l = newNode;
            return;
        }
        Node save = l;
        for (int j = 1; j <= i - 1; j++) {
            if (save == null) {
                System.out.println("Index out of bounds");
                return;
            }
            save = save.rpter;
        }
        if (save != null) {
            newNode.lpter = save.lpter;
            newNode.rpter = save;
            save.lpter.rpter = newNode;
            save.lpter = newNode;
        } else {
            newNode.rpter = null;
            newNode.lpter = r;
            r.rpter = newNode;
            r = newNode;
        }

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

    public void deleteAtAnyPosition(int p) {
    if (r == null && l==null) {
    System.out.println("List is empty");
    return;
    }
    if(l==r && p==l.info){
        l=r=null;
        System.out.println("1");
        return;
    }
    if(p==l.info){
        l=l.rpter;
        l.lpter=null;
        System.out.println("2");
        return;
    }
    if(p==r.info){
        r=r.lpter;
        r.rpter=null;
        System.out.println("3");
        return;
    }

    Node save = l;
    while(save!=null && save.info!=p){
        save=save.rpter;
    }
    if(save!=null){
        save.lpter.rpter=save.rpter;
        save.rpter.lpter=save.lpter;
        System.out.println("4");
        return;
    }
    System.out.println("the given node does not exists");
    }

    public int sizeOfLinkedList(){
    if(r == null && l==null) {
         return 0;
    }
    int count=0;
    Node save=l;
    while(save!=null){
    count++;
    save=save.rpter;
    }
    return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DoublyLinkedListStructure li = new DoublyLinkedListStructure();
        System.out.println("Please Enter 1 if you want to insert a node at 1st position in LL,");
        System.out.println("Please Enter 2 if you want to insert a node at last position in LL,");
        System.out.println("Please Enter 3 if you want to insert a node at any position in LL,");
        System.out.println("Please Enter 4 if you want to delete a node from any position in LL,");
        System.out.println("Please Enter 5 if you want to Display your linkedLIst,");
        System.out.println("Please Enter 6 if you want to get the size of linked list,");
        System.out.println("Please Enter 7 if you want to exit the process");

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
                    System.out.println("Enter the node to be deleted:");
                    int pos = sc.nextInt();
                    li.deleteAtAnyPosition(pos);
                    break;
                case 5:
                    li.display();
                    break;
                case 6:
                    System.out.println("Size of Doubly LL :"+li.sizeOfLinkedList());
                    break;
                case 7:
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