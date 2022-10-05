import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class graphByAdjacencyListUsingLinkedList {
    LinkedList <Integer> [] adj;
    private  int vertices;

    public graphByAdjacencyListUsingLinkedList(int nodes){
        this.vertices = nodes;
        this.adj = new LinkedList[nodes];
        for (int i = 0; i < nodes ; i++) {
            this.adj[i]= new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v){
        this.adj[u].add(v);
        this.adj[v].add(u);
    }

    public void bfs(int s){
        boolean []visited = new boolean[this.vertices];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.offer(s);
        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u+" ");
            for(int v : adj[u]){
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }

    }

    public void dfs(int s){
        boolean [] visited = new boolean[this.vertices];
        Stack<Integer> st = new Stack<>();
        st.push(s);
        while(!st.isEmpty()){
            int u = st.pop();
            if(!visited[u]){
                visited[u] = true;
                System.out.print(u+" ");
                for(int v : adj[u]){
                    if(!visited[v]){
                        st.push(v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of Nodes:- ");
        int nodes = sc.nextInt();
        graphByAdjacencyListUsingLinkedList g = new graphByAdjacencyListUsingLinkedList(nodes);

//        for (int i = 0; i <nodes; i++) {
////            System.out.println("Enter the sources and destination:- ");
//            int source = sc.nextInt();
//            int dest = sc.nextInt();
//            g.addEdge(source, dest);
//
//        }
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(2,4);

        g.bfs(0);
        System.out.println();
        g.dfs(0);
    }
}
