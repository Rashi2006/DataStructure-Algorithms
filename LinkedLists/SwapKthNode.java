import java.util.Scanner;

public class SwapKthNode {
    class Node{
        int info;
        Node link;

        public Node(int data){
            this.info = data;
            this.link = null;
        }
    }
    
    Node first=null;

    public void insertAtfirst(int data) {
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

    public void swap(int k) {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        Node save=first;
        int count=0;
        while(save!=null){
            count++;
            save=save.link;
        }
        if((count<k || k<=0 )){
             System.out.println("Invalid value of k");
             return;
        }
        int back=count-k;
        if(count==1 || (k==back+1)){
            System.out.println("No need to swap");
            return;
        }
        Node start=first;
        Node prev=null;
        Node end=first;
        if(count==2){
           end=start.link;
           end.link=start;
           start.link=null;
           first=end;
           display();
           return;
        }
        
       
        int i=1;
        while(i!=k ){
            prev=start;
            start=start.link;
            i++;
        }
        i=1;
        while(i!=back){
            end=end.link;
            i++;
        }

        if(k==1){
           Node temp=end.link;
           temp.link=start.link;
           end.link=start;
           start.link=null;
           first=temp;
        }else if(start==end){
            
            Node temp=end.link;
            start.link=temp.link;
            temp.link=start;
            prev.link=temp;
        }else{
            Node temp=end.link;
            end.link=temp.link;
            temp.link=start.link;
            prev.link=temp;
            start.link=end.link;
            end.link=start;
        }
        
        display();
        return;
    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SwapKthNode list = new SwapKthNode();

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
                    list.insertAtfirst(n);
                    break;
                case 2:
                    list.display();
                    break;
                case 3:
                    System.out.println("Enter the value of k:");
                    System.out.println("k=");
                    int k=sc.nextInt();
                    list.swap(k);
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
