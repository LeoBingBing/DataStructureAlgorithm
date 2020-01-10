package algorithm.linked;

/**
 * @author wb
 * @date 2019/1/30
 * @description
 */
public class singlyLinkedList {

    //node 对象
    //next 方法
    //基本方法：增删

    private Node head = null;

    public Node findByValue(int value){
        Node p = head;
        while(p != null && p.data != value ){
            p = p.next;
        }
        return  p;
    }

    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while(p != null & pos != index){
            p = p.next;
            ++pos;
        }
        return p;
    }

    public void insertToHead(int value){
        Node nodehead = new Node(value, null);
        insertIntoHead(nodehead);
    }

    public void insertIntoHead(Node newNode){
        if(head == null){
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
    }

    //在某个节点后插入值
    public void insertAfter(Node p , int value){
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }
    public void insertAfter(Node p , Node newNode){
        if(p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    //在某个节点前面插入值
    public void insertBefore(Node p , int value){
        Node newNode = new Node(value,null);
        insertBefore(p, newNode);
    }
    public void insertBefore(Node p , Node newNode){
        if(p == null) return;
        if(head == p){
            insertIntoHead(newNode);
            return;
        }
        Node q = head;
        while(q != null && q.next != p){
           q = q.next ;
        }

        if(q == null){
            return;
        }

        q.next = newNode;
        newNode.next = p;


    }


    public void insertTail(int value){

        Node newHead = new Node(value, null);
        if(head == null){
            head = newHead;
        }else {
            Node q = head.next;
            while (q != null ){
                q = q.next;
            }
            //将空值赋给新添加的对象
            newHead.next = q.next;
            q.next = newHead;
        }

    }



    public static void main(String[] args) {

    }


    // Node
    public static class Node {
        private int data;
        private Node next;

        public  Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }


}
