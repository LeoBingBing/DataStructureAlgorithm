package algorithm.queue;

/**
 * @author wb
 * @date 2019/4/21
 * @description
 */
public class queueDynamic {
    private String [] items;
    private int n;
    private int head =0 ;
    private int tail =0 ;

    public queueDynamic(int size){
        items = new String[size];
        n=size;
    }

    public boolean enqueue(String item){
        if(head==tail){
            if(head==0) return false;

            for(int i = 0;i<head;head++){
                items[i]=items[head];
            }

            tail=tail-head;
            head=0;
        }
        items[tail]=item;
        tail++;
        return true;
    }

    public String dequeue(){
        if(tail==head) return null;
        String item = items[head];
        head++;
        return item;
    }
}
