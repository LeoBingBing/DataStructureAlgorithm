package algorithm.array;

/**
 * @author wb
 * @date 2018/10/12
 * @description
 * 数组按照下表随机访问操作、线性表
 */

public class array {
    //定义存储的数据类型
    public int data[];
    //定义存储大小、即数组长度
    public int n;
    //定义数组中实际个数
    public int count;

    //构造函数初始化
    public array(int capacity){
        this.data=new int[capacity];
        this.n=capacity;
        this.count=0;
    }

    //查询
    public int findByIndex(int index){
        if(index < 0 || index > n) return  -1;
        return data[index];
    }

    //删除
    public boolean deleteByIndex(int index){
        if(index < 0 || index > n) return  false;
        for (int i = index; i < count-1; i++) {
            data[i]=data[i+1];
        }
        --count;
        return  true;
    }
    //插入
    public boolean insertData(int index,int value){
        if(index < 0 || index > n) return false;
        if(count == n) return false;

        for (int i = index; i < count; i++) {
            data[i+1]=data[i];
        }
        data[index]=value;
        ++count;
        return true;
    }

}
