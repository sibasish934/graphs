class Pair implements Comparable<Pair>{
    int v;
    int wt;
        
    Pair(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
        
    public int compareTo(Pair that){
        return this.wt - that.wt;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean []visited = new boolean[V];
        int []arr = new int [V];
        
        Arrays.fill(arr, 999999);
        
        PriorityQueue <Pair> q = new PriorityQueue<>();
        
        q.add(new Pair(S,0));
        arr[S]=0;
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            int u = cur.v;
            
            if(visited[u]){
                continue;
            }
            
            visited[u] = true;
            
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
            
            for(ArrayList<Integer>list : neighbours){
                int vertex = list.get(0);
                int wt = list.get(1);
                
                if(arr[vertex] > arr[u] + wt){
                    arr[vertex] = arr[u] + wt;
                    q.add(new Pair(vertex, arr[vertex]));
                }
            }
        }
        return arr;
    }
}

