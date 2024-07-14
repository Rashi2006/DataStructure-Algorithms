import java.util.Scanner;

public class GCDBtwnTwoNodes {
    class Node {
        int info;
        Node link;

        public Node(int data) {
            info = data;
            link = null;
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

    public void addGCD(){
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
       
        Node save=first;
        while(save!=null && save.link!=null){
            int a=getGCD(save.info,save.link.info );
            Node newNode = new Node(a);
            newNode.link=save.link;
            save.link=newNode;
            save=newNode.link;
        }
        display();
        return;
    }

    public int getGCD(int a , int b){
        int i=1;
        int max=1;
        while(i<=a && i<=b){
            if(a%i==0 && b%i==0){
                max=i;
            }
            i++;
        }
        return max;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GCDBtwnTwoNodes list = new GCDBtwnTwoNodes();
        System.out.println("Enter 1 for inserting elements into 1st Linked List,");
        System.out.println("Enter 2 for displaying Linkedlist");
        System.out.println("Enter 3 for displaying LinkedList with GCD");
        
        boolean isTheEnd=false;
        while(true){
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter the element to be inserted:");
                    int n = sc.nextInt();
                    list.insertAtFirst(n);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    isTheEnd = true;
                    list.addGCD();
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
