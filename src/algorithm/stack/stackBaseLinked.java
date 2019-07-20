package algorithm.stack;

/**
 * @author wb
 * @date 2019/4/13
 * @description
 *
 * 功能：浏览器的前进和后退
 */
public class stackBaseLinked {

    public static void main(String[] args) {
        stackBaseLinked browser = new stackBaseLinked();
        browser.open("www.baidu.com");
        browser.open("www.google.com");
        browser.open("www.sohu.com");
        browser.checkCurrentPage();
        System.out.println("=========================>");
        System.out.println(browser.goBack());
        System.out.println(browser.goForward());
    }

    //===============================>

    private String currentPage;
    private linkedList forwardStack;
    private linkedList backStack;

    public stackBaseLinked(){
        this.forwardStack=new linkedList();
        this.backStack=new linkedList();
    }

    public String goBack(){
        if(this.canGoBack()){
            this.forwardStack.push(this.currentPage);
            String backUrl=this.backStack.pop();
            showUrl(backUrl, "back");
            return backUrl;
        }
        return null;
    }

    public String goForward(){
        if(this.canGoForward()){
            this.backStack.push(this.currentPage);
            String forwardUrl=this.forwardStack.pop();
            showUrl(forwardUrl, "forward");
            return forwardUrl;
        }
        return null;
    }

    public boolean canGoBack(){
        return this.backStack.size() > 0;
    }

    public boolean canGoForward(){
        return this.forwardStack.size() > 0;
    }

    //有一个bug，第一次push时，size不会增加
    public void open(String url){
        if(this.currentPage != null){
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        showUrl(url,"open"); //测试用例而已
    }

    public void showUrl(String url, String prefix){
        this.currentPage=url;
        System.out.println(prefix+"--->"+url);
    }

    public  void checkCurrentPage(){
        System.out.println(" Current page is "+this.currentPage);
    }
    //内部类：栈
    public static class linkedList{
        //定一个位置，哨兵原则
        private Node top=null;
        private int size = 0;

        /**
         *   public void push(int value) {
         *     Node newNode = new Node(value, null);
         *     // 判断是否栈空
         *     if (top == null) {
         *       top = newNode;
         *     } else {
         *       newNode.next = top;
         *       top = newNode;
         *     }
         *   }
         * @param data
         */
        //巧妙利用top==null
        public void push(String data){
            Node head = new Node(data,this.top);
            this.top=head;
            this.size++;
        }

        public String pop(){
            if(top==null)return null;
            String value = top.data;
            top=top.next;

            if(this.size > 0){
                this.size--;
            }
            return value;
        }

        //辅助功能
        public String getTopData(){
            if(top==null){
                return null;
            }
            return top.data;
        }

        public void clear(){
            this.top=null;
            this.size=0;
        }

        public int size(){
            return this.size;
        }
    }
    //内部类：链表
    private static class Node{
        private String data;
        //这个属性的意义，不只是一个变量名称，next 也代表了表面上的意思，就是下一个节点，在这个层面上，next是一个指针
        private Node next;

        public Node(String data){
            this.data=data;
        }

        public Node(String data,Node next){
            this.data=data;
            this.next=next;
        }

        public void setData(String data){
            this.data=data;
        }
        public String getData(){
            return data;
        }

        public void setNext(Node next){
            this.next=next;
        }
        public Node getNext(){
            return this.next;
        }

    }

}
