package algorithm.tree;

/**
 * @author wb
 * @date 2019/7/14 17:32
 *
 * 二叉查找树
 */
public class binarySearchTree {

    private Node tree;

    //查
    public Node find(int data){
        Node p = tree;
        while(p != null){
            if(data<p.data) p=p.left;
            else if (data>p.data)p=p.right;
            else return p;
        }
        return null;
    }
    //插
    public void insert(int data){
        if(tree == null){
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while(p != null){
            if(data < p.data){
                if(p.left == null){
                    p.left=new Node(data);
                    return;
                }
                p=p.left;
            }else {
                if(p.right == null){
                    p.right=new Node(data);
                    return;
                }
                p=p.right;
            }
        }
    }

    /**
     * 删除有三种情况：
     *
     * 1、删除节点没有子节点：父节点指向null
     * 2、删除只有一个子节点的节点：父节点指向子节点
     * 3、删除节点有两个子节点：
     */

    public void delete(int data){
        Node p = tree;//指向要删除的节点，初始化指向根节点
        Node pp = null;//pp 记录的是 p 的父节点

        //判断删除节点是否存在
        while(p != null && p.data != data){
            pp=p;
            if(data>p.data){
                p=p.right;
            }else {
                p=p.left;
            }
        }
        if(p==null) return;

        //两个子节点
        //删除节点是p
        if(p.left != null && p.right != null){
            Node minP = p.right;
            Node minPP = p;

            //找到右子节点中最小节点
            while(minP.left != null){
                minPP=minP;
                minP=minP.left;
            }

            p.data=minP.data;//最小值替换到删除节点上

            p=minP;  //节点互换，pp变为p的父节点，进入只有一个叶子节点的删除步鄹
            pp=minPP;
        }


        //删除节点是叶子节点或者仅有一个子节点
        Node child; //p的子节点，把 p 的子 节点的值取出来赋给 child
        if(p.left != null){
            child=p.left;
        }else if(p.right!=null){
            child=p.right;
        }else {
            child=null;
        }

        if(pp == null) tree = child;//删除的是根节点
        else if(pp.left==p) pp.left = child;
        else pp.right = child;

    }


    //树节点
    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data=data;
        }
    }
}
