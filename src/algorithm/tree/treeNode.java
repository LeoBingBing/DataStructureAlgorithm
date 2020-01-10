package algorithm.tree;

import java.util.Stack;

/**
 * @author wb
 * @date 2019/7/13 23:57
 *
 * 二叉树遍历（递归&非递归）
 */
public class treeNode {
    int val;
    treeNode nodeLeft;
    treeNode nodeRight;
    treeNode(int x){
        val=x;
    }

    /**
     * 递归方式
     * @param root
     */
    //前序遍历
    public static void preOrder(treeNode root){
        if(root != null){
            System.out.print(root.val+" ");
            preOrder(root.nodeLeft);
            preOrder(root.nodeRight);
        }
    }

    //中序遍历
    public static void midOrder(treeNode root){
        if(root != null){
            midOrder(root.nodeLeft);
            System.out.print(root.val+" ");
            midOrder(root.nodeRight);
        }
    }


    //后序遍历
    public static void afterOrder(treeNode root){
        if(root != null){
            afterOrder(root.nodeLeft);
            afterOrder(root.nodeRight);
            System.out.print(root.val+" ");
        }
    }

    /**
     * 非递归遍历
     * @param root
     */

    //前序遍历
    public static void preNodeOther(treeNode root){

        //栈的作用是存储递归路径，当遍历结束后，可以返回。找到回去的路
        Stack<treeNode> stack = new Stack<treeNode>();
        treeNode node = root;
        while(node != null || !stack.isEmpty()){

            while(node != null){ //同理于递归的终止条件
                System.out.print(node.val+" ");
                stack.push(node);
                node=node.nodeLeft;
            }

            if(!stack.isEmpty()){//弹栈返回上一层的值，继续循环
                node=stack.pop();
                node=node.nodeRight;
            }
        }

    }


    //中序遍历
    public static void midNodeOther(treeNode root){
        Stack<treeNode> stack = new Stack<treeNode>();
        treeNode node = root;

        while( node != null ||!stack.isEmpty()){

            while(node != null){
                stack.push(node);
                node=node.nodeLeft;
            }

            if(!stack.isEmpty()){
                node=stack.pop();
                System.out.print(node.val+" ");
                node=node.nodeRight;
            }
        }
    }

    //后序遍历
    public static void afterNodeOther(treeNode root){
        Stack<treeNode> stack = new Stack<treeNode>();
        treeNode node = root;
        treeNode lastVist = root;

        while(node != null || !stack.isEmpty()){
            while(node != null ){
                stack.push(node);
                node=node.nodeLeft;
            }

            node=stack.peek();
            //最重要的是判断右子节点是否存在或者已经遍历
            if(node.nodeRight == null || node.nodeRight==lastVist){ //终止条件
                System.out.print(node.val+" ");
                node=stack.pop();
                lastVist=node;
                node=null; //右叶子已经为空
            }else {
                node=node.nodeRight;
            }
        }

    }


    public static void main(String [] args){
        treeNode node = new treeNode(10);
        node.nodeLeft=new treeNode(1);
        node.nodeRight=new treeNode(3);
        node.nodeLeft.nodeLeft=new treeNode(5);
        node.nodeRight.nodeLeft=new treeNode(8);

        /**
         *         preOrder(node);
         *         System.out.println();
         *         midOrder(node);
         *         System.out.println();
         *         afterOrder(node);
         */
        //preNodeOther(node);
        //midNodeOther(node);
        afterNodeOther(node);
    }
}
