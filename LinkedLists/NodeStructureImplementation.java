import java.util.Scanner;
class Node {
        // Represents a node of a singly linked list
        int info;
        Node link;

        public Node(int data) {
            this.info = data;
            this.link = null;
        }
    }

public class NodeStructureImplementation {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter data:");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        System.out.println(newNode.info+" "+newNode.link);
    }
}
