import java.util.Scanner;

public class Polynomial {

    class Node {
        // Represents a node of a singly linked list
        int info;
        int power;
        char var;
        Node link;

        public Node(int c, char x, int p) {
            this.info = c;
            this.var = x;
            this.power = p;
            this.link = null;
        }
    }

    public Node first = null;

    public void insertAtLast(int c, char x, int p) {
        Node newNode = new Node(c, x, p);
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
            System.out.print("+" + save.info + "" + save.var + "" + save.power);
            save = save.link;
        }
        System.out.println("");
    }

    public int sizeOfLinkedList() {
        if (first == null) {
            return 0;
        }
        int count = 0;
        Node save = first;
        while (save != null) {
            count++;
            save = save.link;
        }
        return count;
    }
    
    public void merge(Polynomial p2){
        if(first==null){
            first=p2.first;
            finalPolynomial();
            return;
        }
        Node save=first;
        while(save.link!=null){
            save=save.link;
        }
        save.link=p2.first;
        finalPolynomial();
    }
    public void deleteDuplicates() {
        if (first == null) {
            display();
            return;
        }
        Node save = first;

        while (save != null) {
            Node prev = save;
            Node temp = save.link;
            while (temp != null) {
                if (save.var == temp.var && save.power == temp.power) {
                    prev.link = temp.link;
                } else {
                    prev = temp;
                }
                temp = temp.link;
            }
            save = save.link;
        }
    }
    public void finalPolynomial(){
        Node save = first;
        while(save.link!=null){
            Node temp=save.link;
            while(temp!=null){
                if(save.var==temp.var && save.power==temp.power){
                    save.info=save.info+temp.info;
                }
                temp=temp.link;
            }
            save=save.link;
        }
        deleteDuplicates();
        display();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1 to enter Polynomial 1 ");
        System.out.println("Enter 2 to if you have entered Polynomial 1 ");
        System.out.println("Enter 3 to enter Polynomial 2 ");
        System.out.println("Enter 4 to if you have entered Polynomial 1");
        System.out.println("Enter 5 to get the final Polynomial");

        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();

        while (true) {
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the term of polynomial1");
                    int c = sc.nextInt();
                    char x = sc.next().charAt(0);
                    int p = sc.nextInt();
                    p1.insertAtLast(c, x, p);
                    break;
                case 2:
                    System.out.println("Polynomial 1");
                    p1.display();
                    break;
                case 3:
                    System.out.println("Enter the term of polynomial2");
                    c = sc.nextInt();
                    x = sc.next().charAt(0);
                    p = sc.nextInt();
                    p2.insertAtLast(c, x, p);
                    break;
                case 4:
                    System.out.println("Polynomial 2");
                    p2.display();
                    break;
                case 5:
                    p1.merge(p2);
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }
}
