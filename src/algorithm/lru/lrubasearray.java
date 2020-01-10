package algorithm.lru;


import java.util.HashMap;
import java.util.Map;

/**
 * @author wb
 * @date 2019/1/28
 * @description
 */


public class lrubasearray<T> {
    private static final int DEFAULT_CAPACITY = (1 << 3);

    private int capacity;
    private int count;
    private T[] value;

    //用来记录缓存中每个数据的下标。
    // 优化：判断是否在缓存中，如果不设置map，判断对象是否在缓存中的过程的复杂度会增加
    //将缓存的访问时间降低到 O（1），如果使用遍历时间复杂度为 O（n）
    private Map<T,Integer> holder;

    public lrubasearray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }

    public lrubasearray(){
        this(DEFAULT_CAPACITY);
    }

    public void offer(T object){
        //如果对象为空抛出异常
        if(object == null){
            throw new IllegalArgumentException("该缓存容器不支持null！");
        }
        //获取对象是否在缓存中，holder 以 map 形式存储缓存中的对象，简化判断复杂度
        Integer index = holder.get(object);

        if(index==null){
            if(isFull()){
                removeAndCache(object);
            }else {
                cache(object, count);
            }
        }else {
            update(count);
        }
    }
    //更新
    public void update(int end){
        //获取需要移动到数组头部的对象
        T target = value[end];
        //将移动对象左边的所有元素，右移一位，腾出 index:0 的空间
        rightShift(end);
        //将对象放到 index:0 位置，更新缓存
        value[0]=target;
        //map 中同样更新缓存
        holder.put(target, 0);
    }
    //加入缓存
    public void cache(T object,int end){
        rightShift(end);
        value[0]=object;
        holder.put(object,end);
        count++;
    }
    //缓存已满，清空后 再加入
    public void removeAndCache(T object){
        //获取末尾元素
        T key = value[--count];
        //删除末尾元素
        holder.remove(key);
        //加入缓存
        cache(object, count);
    }
    //
    public boolean isConstain(T object){
        return holder.containsKey(object);
    }
    //
    public boolean isEmpty(){
        return count==0;
    }
    //
    public boolean isFull(){
        return count==capacity;
    }




    public void rightShift(int end){
        for (int i = end-1; i >=0 ; i--) {
            value[i+1]=value[i];
            holder.put(value[i],i+1);
        }
    }



    public static void main(String[] args) {
        lrubasearray lru = new lrubasearray();
        System.out.println(lru.capacity);
    }
}
