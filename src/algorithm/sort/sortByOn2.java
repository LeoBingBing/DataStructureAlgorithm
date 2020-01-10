package algorithm.sort;

/**
 * @author wb
 * @date 2019/4/21
 * @description
 *
 * 冒泡排序、插入排序、选择排序
 */
public class sortByOn2 {

    public static void main(String[] args) {
        int a [] = {4,5,6,1,3,2};
        //bubbleSort(a, 6);
        insertSort(a, 6);
        //insertionSort(a, 6);
    }

    //冒泡排序, a 表示数组，n 表示数组的大小
    public static void bubbleSort(int [] a,int n){
        if (n <= 1) return ;

        for (int i = 0; i < n; i++) {

            boolean flag=false;//最好时间复杂度可以减弱为O(N),即只需要比较相邻间的数据大小，flag不会变为true
            // 这里的 n-i-1 ：
            // -i 是因为每次排序之后最后一个位置的数据不需要参与排序，因为已经是最大的了
            // -1 是因为下面的循环中有 j+1
            for (int j = 0; j < n-i-1 ; j++) {
                if(a[j]>a[j+1]){
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                    flag=true;
                }
            }
            if(!flag) break;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
        }
    }

    public static void insertSort(int a [] , int n){
        if(n<=1) return;
        for (int i = 1; i < n ; i++) { //未排序区间，初始元素为 a[0]
            int value = a[i]; //从未排序区间第一个位置上取出数据，跟已排序区间的数据比较，比较顺序，从末端到首段
            int j=i-1;
            for (; j >=0 ; j--) { //已排序区间
                if(a[j]>value){//当已排序区间中的最大值都不大于 value 时，直接跳出当前循环
                    a[j+1]=a[j];//主要赋值操作，移动数据
                }else {
                    break;//跳出循环
                }
            }
            a[j+1]=value;//主要赋值操作。如果出现位置移动则 j 会减小，在取到 1 这个值的时候会减小到 -1
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
        }
    }

    public static void selectionSort(int [] a,int n ){
        if(n <= 1) return;

        for (int i = 0; i <n -1; i++) { //未排序区间，初始元素个数为0
            //从未排序区间查找最小元素，依次放到数组前排
            int mini=i;
            for (int j = i+1; j <n ; j++) { //已排序区间
                if(a[j]<a[mini]){
                    mini = j;
                }
            }
            int tmp = a[i];
            a[i]=a[mini];
            a[mini]=tmp;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

    }


}
