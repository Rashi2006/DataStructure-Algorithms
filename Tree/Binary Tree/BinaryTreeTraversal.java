import java.util.*;

public class BinaryTreeTraversal {
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
    public int idx = -1;

    public Node buildTree(int[] nodes) {
        idx++;
        
        if (idx>=nodes.length||nodes[idx] == -1) {
            return null;
        }
        
        Node newNode = new Node(nodes[idx]);
        newNode.lpter = buildTree(nodes);
        newNode.rpter = buildTree(nodes);

        return newNode;
    }

    public void RPREORDER(Node t) {
        if (t == null) {
            System.out.print("-1 ");
            return;
        }
        System.out.print(t.info + " ");
        RPREORDER(t.lpter);
        RPREORDER(t.rpter);

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

    public void RPOSTORDER(Node t) {
        if (t == null) {
            System.out.print("-1 ");
            return;
        }

        RPOSTORDER(t.lpter);
        RPOSTORDER(t.rpter);
        System.out.print(t.info + " ");

    }

    public void levelOrder(Node t) {
        if (t == null) {
            System.out.println("Empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(t);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node currNode = queue.remove();
            if (currNode == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                System.out.print(currNode.info + " ");
                if (currNode.lpter != null) {
                    queue.add(currNode.lpter);
                }
                if (currNode.rpter != null) {
                    queue.add(currNode.rpter);
                }

            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes to build tree");
        int n = sc.nextInt();

        System.out.println("Enter 1 if you want to add element in the tree,");
        System.out.println("Enter 2 if you want to print PREORDER TRAVERSAL,");
        System.out.println("Enter 3 if you want to print RINORDER TRAVERSAL,");
        System.out.println("Enter 4 if you want to print RPOSTORDER TRAVERSAL,");
        System.out.println("Enter 5 if you want to print LevelOrder TRAVERSAL,");
        System.out.println("Enter 6 if you want to exit from the process");

        BinaryTreeTraversal bTree = new BinaryTreeTraversal();

        while (true) {
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (n == 0) {
                        System.out.println("Tree is empty");
                    } else {
                        int[] nodes = new int[n];
                        for (int i = 0; i < n; i++) {
                            System.out.println("nodes[" + i + "] = ");
                            nodes[i] = sc.nextInt();
                        }

                        bTree.t = bTree.buildTree(nodes);
                        System.out.println(bTree.t.info);
                    }
                    break;
                case 2:
                    System.out.println("Root to leaf path using RPREORDER traversal:");
                    bTree.RPREORDER(bTree.t);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\nRoot to leaf path using RINORDER traversal:");
                    bTree.RINORDER(bTree.t);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\nRoot to leaf path using R POSTORDER traversal:");
                    bTree.RPOSTORDER(bTree.t);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("\nRoot to leaf path using LEVEL ORDER traversal:");
                    bTree.levelOrder(bTree.t);
                    System.out.println();
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice");
                    break;
            }
        }

    }

}
