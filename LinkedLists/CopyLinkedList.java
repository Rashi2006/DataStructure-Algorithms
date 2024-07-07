import java.util.Scanner;
public class CopyLinkedList{
    class Node{
        int info;
        Node link;

        public Node(int data){
            this.info=data;
            this.link=null;
        }
    }
    
    Node first=null;

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

    public void copyList(CopyLinkedList copy){
        if(first == null){
            System.out.println("List is empty");
            return ;
        }
        Node save=first;
        while(save!=null){
            copy.insertAtLast(save.info);
            save=save.link;
        }
        copy.display();
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CopyLinkedList list1 = new CopyLinkedList();
        System.out.println("Enter 1 for inserting elements into 1st Linked List,");
        System.out.println("Enter 2 for displaying Linkedlist 1");
        System.out.println("Enter 3 for creating a copy od LinkedList you have created");
        
        boolean isTheEnd=false;
        while(true){
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter the element to be inserted:");
                    int n = sc.nextInt();
                    list1.insertAtLast(n);
                    break;
                case 2:
                    list1.display();
                    break;
                case 3:
                    isTheEnd = true;
                    CopyLinkedList list2 = new CopyLinkedList();
                    list1.copyList(list2);
                    break;
                default:
                    System.out.println("invalid choice");
            }
            if(isTheEnd){
                break;
            }
        }
    }
}