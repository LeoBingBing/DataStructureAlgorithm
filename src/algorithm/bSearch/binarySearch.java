package algorithm.bSearch;

/**
 * @author wb
 * @date 2019/5/3
 * @description
 *
 *十个二分九个错
 * 小道消息：1946年第一个二分法出现，但是直到1962年，第一个正确的二分算法才实现
 */
public class binarySearch {

    public static void main(String[] args) {
        int a [] ={1,2,4,4,4,5,6,7,10};
        int n = a.length;

        //System.out.println(binSearchByCycle(a, n, 0));

        //System.out.println(binSearchByRecursion(a,0,n-1,7));

        //System.out.println(binSearByCycleFindFirstEle(a,n,4));

        //System.out.println(binSearByRecursionFindLastEle(a,0,n-1,4));

        //System.out.println(binSearchByCleFindFirstLtgtEle(a,n,8));

        System.out.println(binSearchByCleFindLastRtgtEle(a,0,n-1,8));
    }


    //递归：
    public static int binSearchByRecursion(int a[] , int p , int r, int value){
        if(p>r)return -1;//p==r时，如果a[mid]！=value , 则会进入下一次递归， p>r ，返回 -1

        int mid = p+((r-p)>>1);

        if(a[mid]==value){
            return mid;
        }else if(a[mid]>value){
            r=mid-1;
            return binSearchByRecursion(a, p, r, value);
        }else {
            p=mid+1;
            return binSearchByRecursion(a, p, r, value);
        }
    }


    //循环
    public static int binSearchByCycle(int a [],int n , int value){
        int p = 0;
        int r = n-1;

        while (r>=p) {
            //三种表达方式
            // (r+p)/2 这种可能溢出
            // p+(r-p)/2
            //极致：p+((r-p)>>1)
            int mid = p+((r-p)>>1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                r = mid - 1;
            } else {
                p = mid + 1;
            }
        }
        return -1;
    }



    //变体一：查找等于某个值的第一个元素
    public static int binSearByCycleFindFirstEle(int a [],int n,int value){
        int p = 0;
        int r = n-1;

        while (r>=p){
            int mid = p+((r-p)>>1);

            if(a[mid]>value){
                r = mid-1;
            }else if(a[mid]<value){
                p = mid+1;
            }else {
                //两种情况，当 mid==0 ,数组的第一个元素
                //当前元素前一位不等
                if(mid==0 || (a[mid-1]!=value))return mid;
                else r = mid-1;
            }
        }
        return -1;
    }
    //变体二：查找等于某个值的最后一个元素
    public static int binSearByRecursionFindLastEle(int a [] ,int p,int r,int value){

        int mid = p+((r-p)>>1);

        if(a[mid]>value){
            p = mid+1;
            return binSearByRecursionFindLastEle(a,p,r, value);
        }else if(a[mid]<value){
            r = mid-1;
            return binSearByRecursionFindLastEle(a,p,r, value);
        }else {
            if(mid==r || (a[mid+1])!=value) return mid;
            else
                p=mid+1;
            return binSearByRecursionFindLastEle(a,p,r, value);
        }

    }

    //查找第一个大于等于某个值的元素
    public static int binSearchByCleFindFirstLtgtEle(int a[],int n ,int value){
        int p = 0;
        int r = n-1;

        while(r>=p){
            int mid = p+((r-p)>>1);

            if(a[mid]==value){
                return mid;
            }else if(a[mid]>value){
                if(a[mid-1]>value) r = mid-1;
                else return mid;
                /**
                 * if (mid==0 || a[mid-1]<value) return mid;
                 * else r = mid-1;
                 */
            }else {
                p = mid+1;
            }
        }

        return -1;
    }

    //变体四：查找最后一个小于等于某个值的元素
    public static int binSearchByCleFindLastRtgtEle(int a [],int p,int r,int value) {

        int mid = p + ((r - p) >> 1);

        if (a[mid] == value) {
            return mid;
        }else if(a[mid]<value){
            if(mid==r || a[mid+1]>value) return mid;
            else  p = mid+1;
            return binSearchByCleFindLastRtgtEle(a,p,r,value);
        }else {
            r = mid-1;
            return binSearchByCleFindLastRtgtEle(a,p,r,value);
        }
    }
}
