import java.util.*;

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
    // This is code for the find shortest path between the source and dest nodes in undirected and unweighted graph.
    public void shortestPath(int s, int d){
        Queue<Integer> q = new LinkedList<>();
        boolean []visited = new boolean[this.vertices];
        int []parent = new int[this.vertices];

        q.offer(s);
        visited[s] = true;
        parent[s] = -1;

        while(!q.isEmpty()){
            int v = q.poll();
            for(int i : this.adj[v]){
                if(!visited[i]){
                    q.offer(i);
                    parent[i] = v;
                }
            }
        }

        int curr = d;
        ArrayList<Integer>list = new ArrayList<>();
        list.add(curr);
        while(curr != s){
            curr = parent[curr];
            list.add(curr);
        }

        System.out.println("The shortest Path node :-");
        for (int i : list){
            System.out.print(i + " ");
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
        g.shortestPath(0,4);
    }
}
