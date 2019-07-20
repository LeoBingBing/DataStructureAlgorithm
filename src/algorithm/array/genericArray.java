package algorithm.array;

/**
 * @author wb
 * @date 2019/1/26
 * @description
 */
public class genericArray<T> {
    public T[] data;
    public int size;

    public genericArray(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }
    //空构造函数，数组默认长度为 10
    public genericArray(){
        //当前 this 调用同一类中的其他方法。本类中 genericArray（int capacity）
        //在子类中会有 super 方法，该方法会调用父类中的构造函数
        //个人想法：这种方式还是为了降低耦合，高效的提取封装
        this(10);
    }
    //获取数组大小
    public int getCapacity(){
        return data.length;
    }
    //判断数组是否为空
    public boolean isEmpty(){
        return  size == 0;
    }
    //修改 index 位置的元素
    public void set(int index , T e){
        checkIndex(index);
        data[index]=e;
    }
    //获取 index 位置的元素
    public T get(int index){
        checkIndex(index-1);
        return data[index-1];
    }
    //查看数组是否包含元素 e
    public boolean contains(T e){
        for (int i = 0; i < size ; i++) {
            if (e.equals(data[i])){
                return true;
            }
        }
        return false;
    }
    //获取对应元素的下标，不存在返回 -1
    public int find(T e){
        for (int i = 0; i < size ; i++) {
            if(e.equals(data[i])){
                return i;
            }
        }
        return -1;
    }
    //在 index 位置插入新元素 e ，时间复杂度为 O(m+n)
    public void add(int index , T e){
        checkIndex(index);
        if(size==data.length){
            resize(2*size);
        }
        for (int i = size - 1; i >= index; i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }
    //向数组头部添加元素
    public void addFirst(T e){
        add(0, e);
    }
    //向数组尾部添加元素
    public void addLast(T e){
        add(size, e);
    }
    //删除 index 位置的元素，并返回
    public T remove(int index){
        checkIndexForRemove(index);
        T ret = data[index];
        for (int i = index; i < size; i++) {
            data[i]=data[i+1];
        }
        size--;//假设当前size=10，data[size=9]，将之前最后一位清空
        data[size]=null;

        if (size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }

        return ret;
    }
    //删除第一个元素
    public T reomveFirst(){
        return remove(0);
    }
    //删除最后一个元素
    public T removeLast(){
        return remove(size-1);
    }
    //删除指定元素
    public void removeElement(T e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    //动态扩容
    public void resize(int capacity){
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size ; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //检查请求参数是否正确
    public void checkIndex(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add fail! Require index >= 0 and index <= size");
        }
    }
    //删除操作，检查请求参数是否正确
    public void checkIndexForRemove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("remove fail!  Require index >= 0 and index < size");
        }
    }
}
