 public class LinkedList{
    class Node{
        int info;
        Node link;

        public Node(int data){
            this.info=data;
            this.link=null;
        }
    }

    public  Node first=null;

    public void insertAtFirst(int data){
        Node newNode = new Node(data);

        if(first==null){
            first=newNode;
            return;
        }
        Node temp=first;
        first=newNode;
        first.link=temp;
        System.out.println(newNode.info);
    }

    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        li.insertAtFirst(5);
        // li.insertAtFirst(6);
    }
}