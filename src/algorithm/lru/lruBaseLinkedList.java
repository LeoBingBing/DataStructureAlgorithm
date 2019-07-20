package algorithm.lru;

/**
 * @author wb
 * @date 2019/2/11
 * @description
 */

/**
 *lru:缓存淘汰算法
 * 1、链表的头部是最新缓存的数据
 * 2、当有一个新的数据进行访问时，进行链表的遍历（此步骤为判断数据是否在缓存中，可以使用哈希表来优化时间复杂度。参考数组）
 * 3、如果链表中已经存在，删除，重新插入到链表头部
 * 4、如果不存在。
 *   4.1、缓存未满，直接插入到头部
 *   4.2、缓存已满，删除尾部数据，插入头部数据
 */

public class lruBaseLinkedList<T> {
    //默认链表容量
    private final static Integer DEFAULT_CAPACITY = 10;
    //头结点
    private Snode<T> headNode;
    //链表长度
    private Integer length;
    //链表容量
    private Integer capacity;

    public lruBaseLinkedList(){
        /*this.headNode = new Snode<>();
        this.length = 0;
        this.capacity=DEFAULT_CAPACITY;*/
        this(DEFAULT_CAPACITY);
    }

    public lruBaseLinkedList(Integer capacity){
        this.headNode = new Snode<>();
        this.length = 0;
        this.capacity=capacity;
    }

    //add
    public void add(T data){
        //遍历查找 元素 是否已经在链表中
        Snode pre = findPreNode(data);
        //如果链表中已经存在，删除原始的，重新在头部插入新的
        if(pre != null){
            deleteElemOptim(pre);
            insertElemAtBegin(data);
        }else {
            if(length >= this.capacity){
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    //delete by snode
    public void deleteElemOptim(Snode snode){
        Snode tmp = snode.getNext();
        snode.setNext(tmp.getNext());
        tmp=null;
        length--;
    }

    //insert
    public void insertElemAtBegin(T data){
        Snode snode = headNode.getNext();
        headNode.setNext(new Snode(data,snode));
        length++;
    }

    //find
    public Snode findPreNode(T data){
        Snode snode = headNode;
        while (snode.getNext() !=null){
            if(data.equals(snode.getNext().getElement())){
                return snode;
            }
            snode = snode.getNext();
        }
        return null;
    }

    //delete
    public void deleteElemAtEnd(){
        //获取当前头部节点，如果为空，返回
        Snode pre = headNode;
        if(pre.getNext() == null){
            return;
        }
        //获取倒数第二个节点，遍历到为止
        while(pre.getNext().getNext() != null){
            pre=pre.getNext();
        }

        Snode last=pre.getNext();
        pre.setNext(null);
        last = null;
        length--;
    }

    //链表节点
    public class Snode<T>{
        private T element;

        private Snode next;

        public Snode(T element){
            this.element=element;
        }

        public Snode(T element,Snode next){
            this.element=element;
            this.next=next;
        }

        public Snode(){
            this.next=null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Snode getNext() {
            return next;
        }

        public void setNext(Snode next) {
            this.next = next;
        }
    }
}
