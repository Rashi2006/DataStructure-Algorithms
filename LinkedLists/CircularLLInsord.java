import java.util.Scanner;
public class CircularLLInsord {

    class Node{
        int info;
        Node link;

        public Node(int data){
            this.info=data;
            this.link=null;
        }
    }
    
    Node first=null;
    Node last=null;
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

    public void insord(int x){
        Node newNode = new Node(x);
        //when List is empty
        if(first==null){
            first=last=newNode;
            newNode.link=first;
            return;
        }
        //when x is less than first so it will be inserted at First position
        if(x<first.info){
            newNode.link=first;
            last.link=newNode;
            //move the FIRST pointer at newNode
            first=newNode;
            return;
        }
        Node save=first;
        //traverse through the LL till the correct position is not found
        while(save!=last && save.link.info<=x){
            save=save.link;
        }
        //Insert the NewNode at suitable position
        newNode.link=save.link;
        save.link=newNode;
        //when we insert NewNode at last postion move the LAST pointer at the NewNode1

        if(save==last){
            last=newNode;
        }
        return;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);

        CircularLLInsord list = new CircularLLInsord();

        System.out.println("Enter 1 for inserting nubers into Circular linked list,");
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


