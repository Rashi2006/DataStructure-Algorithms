import java.util.Scanner;

public class SplitCircularLinkedList {
    class Node{
        int info;
        Node link;

        public Node(int data){
            this.info = data;
            this.link = null;
        }
     } 
        Node first=null;
        Node last=null;

        public void insertAtFirst(int data){
            Node newNode = new Node(data);
             if(first==null){
                first=last=newNode;
                newNode.link=first;
                return;
             }
             newNode.link = first;
             last.link = newNode;
             first=newNode;
        }

        public void display(){
            if(first==null){
                System.out.println("List is empty");
                return;
            }
            Node save=first;
            do{
                System.out.print(save.info + "-->");
                save=save.link;
            }while(save!=first);
            System.out.print("last");
            System.out.println("");
        }

        public int sizeOfCircularLinkedList(){
            if(first==null){
                return 0;
            }
            Node save=first;
            int count=0;
            do{
              count++;
              save=save.link;
            }while(save!=first);
            
            return count;
        }

        public void split(){
            
        }

         public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        SplitCircularLinkedList list = new SplitCircularLinkedList();

        System.out.println("Enter 1 for inserting nubers into Circular linked list,");
        System.out.println("Enter 2 if you want to see your LL,");
        System.out.println("Enter 3 to split the circular linked list into two halves.");

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
