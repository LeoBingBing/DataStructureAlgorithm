package algorithm.queue;

/**
 * @author wb
 * @date 2019/4/13
 * @description
 */
public class queueBaseArray {

    private String [] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public queueBaseArray(int capacity){
        items = new String[capacity];
        n=capacity;
    }

    public boolean enqueue(String item){
        if(tail==n) return false;
        items[tail]=item;
        tail++;
        return true;
    }

    public boolean dequeue(){
        if(head==tail) return false;
        String ret = items[head];
        head++;
        return true;
    }

    public void printall(){
        for (int i = head; i <tail ; i++) {
            System.out.println(items[i]);
        }
    }
}
