package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wb
 * @date 2019/9/1 17:24
 */
public class code1 {

    public static void main(String [] args){

        int nums [] = {2,11,7,5};
        int sum = 9;

        //towNumSum(nums,sum);
        towNumSumByMap(nums,sum);
    }

    public static void towNumSum(int [] a,int sum){
        if(a.length==0 || a.length==1) return;

        for (int i = 0; i <a.length-1; i++) {

        int first = a[i];
        int end = sum - first;

            for (int j = i+1; j < a.length; j++) {
                if(a[j]==end){
                    System.out.println(i);
                    System.out.println(j);
                }
            }
        }
    }

    public static void towNumSumByMap(int [] a,int sum){
        if(a.length==0 || a.length==1) return;

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i <a.length ; i++) {
            int end = sum-a[i];
            if(map.containsKey(end)){
                System.out.println(i);
                System.out.println(map.get(end));
            }
            map.put(a[i],i);
        }
    }
}
