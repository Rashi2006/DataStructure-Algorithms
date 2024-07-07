import java.util.Scanner;
public class CircularLLStructure {
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

        public void insertAtLast(int data){
            Node newNode = new Node(data);
            if(first==null){
               first=last=newNode;
               newNode.link=first;
               return;
            }
            newNode.link = first;
            last.link = newNode;
            last=newNode;
        }
        
        public void deleteAtAnyPosition(int x){
            
        }
        public void display(){
            if(first==null){
                System.out.println("List is empty");
            }
            Node save=first;
            do{
                System.out.println(save.info);
                save=save.link;
            }while(save!=first);
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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        CircularLLStructure list = new CircularLLStructure();

        System.out.println("Please Enter 1 if you want to insert a node at 1st position in LL,");
        System.out.println("Please Enter 2 if you want to insert a node at last position in LL,");
        System.out.println("Please Enter 3 if you want to delete a node from any position in LL,");
        System.out.println("Please Enter 4 if you want to Display your linkedLIst,");
        System.out.println("Please Enter 5 if you want to get the size of linked list,");
        System.out.println("Please Enter 6 if you want to exit the process");

        boolean isTheEnd = false;
        while (true) {
            System.out.println("Enter your choice:");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter the number to be inserted at first:");
                    int num1 = sc.nextInt();
                    list.insertAtFirst(num1);
                    break;
                case 2:
                    System.out.println("Enter the number to be inserted at last:");
                    int num2 = sc.nextInt();
                    list.insertAtLast(num2);
                    break;
                case 3:
                    System.out.println("Enter the node to be deleted:");
                    int pos = sc.nextInt();
                    list.deleteAtAnyPosition(pos);
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    System.out.println("Size of Circular LL :"+list.sizeOfCircularLinkedList());
                    break;
                case 6:
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
