package algorithm;

/**
 * @author wb
 * @date 2019/2/12
 * @description
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 1、单链表翻转
 * 2、链表中环的检测
 * 3、两个有序的链表合并
 * 4、删除链表倒数第 N 个节点
 * 5、求链表的中间节点
 *
 * 一点总结：
 * 1、链表操作中最重要的是确定指针的指向问题
 * 2、边界条件需要梳理清晰，链表插入删除操作需要注意首尾节点，引入哨兵（含有哨兵的链表称为带头链表、相反称为非带头链表）
 *  哨兵方式可以很好的简化编程难度的技巧，并对程序有一定的优化
 * 3、删除链表注意释放内存空间
 * */

public class linkedListAlgo {

    //反转链表
    public static Node reverse(Node list){
        //定义链表的头和尾，反转链表后重新写入新的链表
        //相当于定义了两个哨兵，反转之后 headnode 是头结点、previousNode 是尾节点
        Node headnode = null;
        Node previousNode = null;
        //list 应为链表的头部
        Node currentNode = list;
        while(currentNode != null){
            //获取下一个 node
            Node nextnode = currentNode.next;
            if(nextnode == null){
                headnode = currentNode;
            }
            //将当前节点指针反向，指向前一节点
            currentNode.next=previousNode;
            //将前一节点和当前节点同时前移（关系链已经建立，不需要关心被移走的节点）
            currentNode=previousNode;
            nextnode=currentNode;
        }
        return headnode;
    }
    //检测环
    public static boolean checkCircle(Node list){
        if(list == null){
            return false;
        }
        //从节点取出两个对象，一个快节点，一个慢节点
        Node fast = list.next;
        Node slow = list;

        //快节点每次走两步，慢节点每次走一步
        //当快节点为空时，说明非链表环
        //当快节点和慢节点相等，环检测结束

        // fast、fast.next 都需要判断是否为空。。。才能继续 fast.next.next
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }

        return false;
    }

    //两个有序链表合并。
    //可以发散的想象成衣服上的拉链，拉锁不动，拉链在移动
    public static Node mergerSortedLists(Node la,Node lb){
        if(la == null) return lb;
        if(lb == null) return la;

        Node head;

        if(la.data < lb.data){
            head = la;
            la = la.next;
        }else {
            head = lb;
            lb = lb.next;
        }

        Node r = head;

        while(la !=null && lb != null){
            if(la.data < lb.data){
                r.next = la;
                la = la.next;
            }else {
                r.next = lb;
                lb = lb.next;
            }
            //不断更新首节点，在这个过程中，整个关系链已经形成，不需要在意之前已经建立的指向关系
            r = r.next;
        }

        if(la != null){
            r.next = la;
        }else {
            r.next = lb;
        }

        return head;
    }

    //删除倒数第 K 个节点
    //思想：同快慢指针
    public static Node deleteLastKth(Node list , int k){

        Node fast = list;
        int i = 1;
        while(fast != null && i < k){
            fast = fast.next;
            ++i;
        }

        if(fast == null ) return  list;

        Node slow = list;
        //pre 的作用，删除头部节点
        Node pre = null;

        //fast 比 slow 快 k-1 步
        //slow 比 pre 快 一步
        while(fast.next != null){
            fast = fast.next;
            //当 fast 走到链表尾部时 pre 就在 k 的位置上
            pre = slow;
            //当 fast 走到链表尾部时，slow 在 k 的 next 位置
            slow = slow.next;
        }

        if(pre == null){
            list = list.next;
        }else {
            pre.next = pre.next.next;
        }

        return list;
    }

    //求链表的中间节点
    //同上，快慢指针，快指针走两步、慢指针走两步
    public static Node findMiddleNode(Node list){
        if(list == null) return  list;

        Node fast = list;
        Node slow = list;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public class Node{
        private int data;
        private Node next;

        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
        public int getData(){
            return data;
        }
    }
}