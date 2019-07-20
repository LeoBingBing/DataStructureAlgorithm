package algorithm.queue;

/**
 * @author wb
 * @date 2019/4/15
 * @description
 */
public class queueBaseLinked {

    //初始化队头和队尾
    private Node head=null;
    private Node tail=null;



    //入队
    public void enqueue(int data){
        if(tail==null){
            Node newnode = new Node(data,null);
            head=newnode;
            tail=newnode;
        }else {
            tail.next=new Node(data,null);
            tail=tail.next;
        }
    }
    //出队
    public int dequeue(){
        if(head==tail) return -1;
        int value = head.data;
        head=head.next;
        if(head==null){
            tail=null;
        }
        return value;
    }


    //内部类
    public static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data=data;
        }

        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }

        public int getData(){
            return data;
        }

        public void setData(int data){
            this.data=data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
