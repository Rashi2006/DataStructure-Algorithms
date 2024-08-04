import java.util.*;

public class BST_Insert_Search_Delete {
    class Node {
        int info;
        Node lpter;
        Node rpter;

        public Node(int data) {
            info = data;
            lpter = null;
            rpter = null;
        }
    }

    public Node t = null;

    public Node insert(Node t, int data) {

        if (t == null) {
            t = new Node(data);
            return t;
        }

        Node newNode = new Node(data);
        if (t.info > newNode.info) {
            t.lpter = insert(t.lpter, data);
        } else {
            t.rpter = insert(t.rpter, data);
        }
        return t;
    }

    public boolean search(Node t, int data) {
        if (t == null) {
            return false;
        }
        if (t.info == data) {
            return true;
        }

        if (t.info > data) {
            return search(t.lpter, data);
        } else {
            return search(t.rpter, data);
        }

    }

    public void RINORDER(Node t) {
        if (t == null) {
            System.out.print("-1 ");
            return;
        }

        RINORDER(t.lpter);
        System.out.print(t.info + " ");
        RINORDER(t.rpter);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        BST_Insert_Search_Delete bst = new BST_Insert_Search_Delete();
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("nodes[" + i + "] = ");
            nodes[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bst.t = bst.insert(bst.t, nodes[i]);
        }
        System.out.println(bst.t);
        bst.RINORDER(bst.t);
        System.out.println("Enter the number to serach:");
        int k=sc.nextInt();
        if(bst.search(bst.t, k)){
            System.out.println("found");
        }else{
            System.out.println("Not found");
        }
    }
}
