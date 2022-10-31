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
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        boolean [] visited = new boolean[V];
        int ans = 0;
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, 0));
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int u = cur.v;
            int wt = cur.wt;
            
            if(visited[u]){
                continue;
            }
            
            ans += wt;
            visited[u] = true;
            
            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);
            
            for(ArrayList<Integer> list : neighbours){
                int vertex = list.get(0);
                int weight = list.get(1);
                
                if(!visited[vertex]){
                    q.add(new Pair(vertex, weight));
                }
            }
        }
        return ans;
    }
}
