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

        public void split(SplitCircularLinkedList list2){
            if(first==null){
                System.out.println("List is empty");
                return;
            }
            int count=sizeOfCircularLinkedList();
            int mid=count/2;
            
            Node save=first;
            Node prev=null;
            int i=0;

            while(i<mid){
                prev=save;
                save=save.link;
                i++;
            }
           
            
            prev.link=first;

            list2.first=save;
            Node temp=save;
            while(temp.link!=first){
                temp=temp.link;
            }
            temp.link=list2.first;
            
            last=prev;
            list2.last=temp;
            System.out.println("Split Successful");
        }
        

       
         public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        SplitCircularLinkedList list1 = new SplitCircularLinkedList();

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
                    list1.insertAtFirst(n);
                    break;
                case 2:
                    list1.display();
                    break;
                case 3:
                SplitCircularLinkedList list2 = new SplitCircularLinkedList();
                    list1.split(list2);
                    list1.display();
                    list2.display();
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