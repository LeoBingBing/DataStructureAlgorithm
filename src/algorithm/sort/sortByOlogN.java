package algorithm.sort;

import sun.security.krb5.internal.tools.Kinit;

/**
 * @author wb
 * @date 2019/4/21
 * @description
 *
 * 归并排序、快速排序
 *
 * 总结：两种排序思想都是分治
 * 归并重要的是合并函数，注意合并的位点
 * 快排重要的是分区函数，重要的是比较的过程，如何找到pivot的位点
 */
public class sortByOlogN {


    public static void main(String[] args) {

        int a [] = {1,5,6,2,3,4,7};
        int n = a.length;

        //归并排序
        //mergeSort(a, n);

        //快速排序
        quickSort(a, n);

        for (int i = 0; i < n ; i++) {
            System.out.print(a[i]);
        }

    }

    //归并排序：每次取中间位置的数据，进行数组拆分，
    // 当不能拆分时，开始进行合并，合并过程中涉及比较，数据重组，需要额外占用 N 大小的空间
    public static void mergeSort(int []a ,int n){
        mergeSort(a, 0, n-1);
    }

    public static void mergeSort(int [] a , int p ,int r){
        if(p>=r) return;//递归算法的终止条件 . ??? 这里不太明白为什么要 >=

        int q = p + (r-p)/2;//防止 r+p 大于 int 最大值

        //分治思想
        mergeSort(a, p, q);//递归算法的子问题
        mergeSort(a, q+1, r);

        //递归算法很容易陷入不断想象的困境中，想把整个过程想明白，递--->归，只要想象最后一次就好

        //每一次递归都有一次 merge
        //第一次执行merge是当上面的 mergeSort 方法中的 p>=r,函数跳出，继续往下执行，轮到 merge了

        //上面是将数组分散开，当数组被分散为每个数组大小为 1 时，分解完毕
        // 这个函数是开始进行比较合并
        merge(a, p, q, r);

    }

    //不是每一次 merge 都是从 0 开始
    public static void merge(int [] a,int p ,int q,int r){

        int i = p; //只有最后一次合并的时候才会是 0
        int j = q+1;
        int k = 0;
        int [] tmp = new int [r-p+1];

        while(i<=q && j<=r){
            if(a[i]<a[j]){ // 从大到小 。从小到大
                tmp[k]=a[i];
                i++;
            }else {
                tmp[k]=a[j];
                j++;
            }
            k++;
        }

        int start = i;
        int end = q;
        if(j<=r){
            start=j;
            end=r;
        }

        while(start<=end){
            tmp[k++]=a[start++];
        }


        //重新拷贝到 a []
        for (int l = 0; l <=r-p ; l++) {
            a[p+l]=tmp[l]; //p+l 说明每次不是从 0 开始
        }

    }


    //快速排序：
    public static void quickSort(int a[],int p){
        quickSort(a, 0, p-1);
    }

    public static void quickSort(int [] a, int p , int r){

        if(p>=r)return;

        int q=partition(a,p,r);//获取分区点

        //递归调用，进行分区
        // 当每个区间大小都为 1 时，排序完成
        quickSort(a, 0, q-1);
        quickSort(a, q+1, r);

    }

    // 分区函数只需要数组的起始和终止位置即可，默认取终止位置的数据作为 pivot
    public static int partition(int[] a ,int p , int r){
        int pivot = a[r];

        int j = p;
        for (int i = p; i < r; i++) {
            if(a[i] < pivot){
                if(i==j){
                    j++;
                }else {
                    int tmp=a[i];
                    a[i]=a[j];
                    a[j]=tmp;
                    j++;

                }
            }
        }

        //pivot 交换
        int tmp = a[j];
        a[j]=pivot;
        a[r]=tmp;


        return j;
    }

}
