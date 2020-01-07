package algorithm.heap;

/**
 * @author wb
 * @date 2019/7/20 11:49
 */
public class aboutHeap {

    //建堆
    //两种方式：
    //一、初始数组只有一个元素，利用堆插入操作，每次追加到最后一个位置，然后堆化。数组取数是从下标0~N，堆化是从下到上
    //二、初始数组有所有数据，直接堆化。堆化是从上往下，叶子节点没有子节点可以跳过。

    //应用特点，主要利用大顶堆和小顶堆的特点，既定场景进行选择
    private static int [] buildheap(int [] a,int n){
        for (int i = n/2 ; i > 0 ; i--) { //  n/2 就是第一个非叶子节点，然后不断堆化即可
            heapify(a,n,i);
        }
        return a;
    }

    //堆化
    private static void heapify(int [] a ,int n , int i){
        while(true){ //多层堆化
            int maxPos = i;
            if(2*i <= n && a[i]<a[2*i]) maxPos=2*i;
            if(2*i+1 <= n && a[maxPos] < a[2*i+1]) maxPos=2*i+1;

            if(maxPos==i)break;
            swap(a , i ,maxPos);

            i=maxPos;
        }
    }
    //交换
    private  static void swap(int [] a,int i , int maxPos){
            int tmp=a[i];
            a[i]=a[maxPos];
            a[maxPos]=tmp;
    }




    public static void main(String [] args){
        int [] a = {0,3,1,2,6,8,4,9,7,10};
        int n = a.length-1;// len = index

        /*int [] s = buildheap(a,n);
        for (int i = 0; i <s.length; i++) {
            System.out.print(s[i]+" ");
        }*/

        //排序
        for (int i = 0; i <a.length ; i++) {

            if(n==0) break;
            int [] s = buildheap(a,n);

            System.out.print(s[1]+" ");

            s[1]=s[n]; //把末尾元素放到首位
            n=n-1;

        }

    }
}
