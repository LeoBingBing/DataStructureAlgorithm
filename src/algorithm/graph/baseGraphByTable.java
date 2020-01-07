package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wb
 * @date 2019/7/21 13:46
 */

//邻接表
public class baseGraphByTable {
    private int v; //图上顶点的个数
    private LinkedList<Integer> adj[];

    public baseGraphByTable(int v){
        this.v=v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i]=new LinkedList<>(); //初始化数组
        }
    }

    public void addEdge(int s ,int t){ //无向图，每边都需要添加
        adj[s].add(s);
        adj[t].add(t);
    }

    //广度优先 ： 借助队列
    public void bfs(int s,int t){//开始节点。结束节点
        if(s==t)return;
        boolean [] visited = new boolean[v];//存储已经访问过的顶点
        visited[s]=true;
        Queue<Integer> queue = new LinkedList<Integer>(); //就是图的每一层 存一下
        queue.add(s);
        int [] prev = new int[v]; //用来打印轨迹的
        for (int i = 0; i <v ; i++) {
            prev[i]=-1;
        }
        while (queue.size()!=0){
            int w = queue.poll();//每一个顶点取出来，遍历对应的子节点
            for (int i = 0; i <adj[w].size(); i++) {
                int q=adj[w].get(i);
                if(!visited[q]){
                    prev[q]=w;
                    if(q==t){
                        print(prev,s,t);
                        return;
                    }
                    visited[q]=true;
                    queue.add(q);
                }
            }
        }
    }

    public void print(int [] prev,int s ,int t){
        if(prev[t]!=-1 && t != s){
            print(prev,s,prev[t]);
        }
        System.out.println(t+" ");
    }

    //深度优先 ： 借助递归调用栈。回溯思想
    boolean found=false;

    public void dfs(int s, int t){
        found=false;
        boolean [] visited = new boolean[v];
        int [] prev = new int[v];
        for (int i = 0; i <v ; i++) {
            prev[i]=-1;
        }
        recurDfs(s,t,visited,prev);

    }

    public void recurDfs(int w,int t,boolean [] visited , int [] prev){
        if(found==true)return;
        visited[w]=true;
        if(w==t){
            found=true;
            return;
        }

        for (int i = 0; i <adj[w].size(); i++) {
            int q = adj[w].get(i);
            if(!visited[q]){
                prev[q]=w;
                recurDfs(q,t,visited,prev);
            }
        }
    }
}
