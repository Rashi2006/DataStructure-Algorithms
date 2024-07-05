import java.util.Scanner;

public class InsertIntoOrderedLL {
    class Node{
        int info;
        Node link;

        public Node(int data){
            this.info=data;
            this.link=null;
        }
    }
    
    Node first=null;

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

    public void insord(int x){
        Node newNode = new Node(x);
        if(first==null || newNode.info<=first.info){
            newNode.link=first;
            first=newNode;
            display();
            return;
        }

        Node save = first;
        while(save.link!=null && newNode.info>=save.link.info){
            save=save.link;
        }
        newNode.link=save.link;
        save.link=newNode;
        display();
        return;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        InsertIntoOrderedLL list = new InsertIntoOrderedLL();

        System.out.println("Enter 1 for inserting nubers into linked list,");
        System.out.println("Enter 2 if you want to see your LL,");
        System.out.println("Enter 3 to terminate .");

        boolean istheEnd = false;
        while (true) {
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to be inserted:");
                    int n = sc.nextInt();
                    list.insord(n);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
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
