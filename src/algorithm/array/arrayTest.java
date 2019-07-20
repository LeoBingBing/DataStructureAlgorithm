package algorithm.array;

/**
 * @author wb
 * @date 2018/10/14
 * @description
 * test
 * 1、
 */
public class arrayTest {


   /*public static void main(String[] args) {
        array a = new array(3);
        System.out.println(a.insertData(0, 1));
        System.out.println(a.insertData(1, 11));
        System.out.println(a.insertData(2, 111));
        System.out.println(a.count);
        for (int i = 0; i < a.count ; i++) {
            System.out.println(a.findByIndex(i));
        }
        System.out.println(a.deleteByIndex(0));
        System.out.println(a.findByIndex(0));
    }*/
   public static void main(String[] args) {
       genericArray array = new genericArray();
       array.addFirst(1);
       array.set(1, 2);
       System.out.println(array.get(1));
       //heheh
   }
}
