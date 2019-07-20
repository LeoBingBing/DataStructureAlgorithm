package algorithm.queue;

/**
 * @author wb
 * @date 2019/4/18
 * @description
 */
public class queueByCircle {

    private String [] items;
    private int size=0;

    private int head=0;
    private int tail=0;

    public queueByCircle(int n){
        items = new String[n];
        size=n;
    }

    //入队
    public boolean enqueue(String item){
        if((tail+1)%size==head) return false;
        items[tail]=item;
        tail=(tail+1)/size;
        return true;
    }

    //出队
    public String dequeue(){
        if(head==tail) return null;
        String item = items[head];
        head=(head+1)/size;
        return item;
    }

}
