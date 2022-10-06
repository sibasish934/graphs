class Solution {
    // Function to detect cycle in an undirected graph.
    int vertices;
    Map<Integer, Integer> map = new HashMap<>();
    Queue<Integer>q = new LinkedList<>();
    boolean [] visited;
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        vertices = V;
        for(int i= 0; i < V; i++){
            boolean ans = Cycle(i,adj);
            if(ans == true){
                return true;
            }
        }
        
        return false;
         
    }
    
    public boolean Cycle(int src, ArrayList<ArrayList<Integer>> adj){
        visited = new boolean[vertices];
        map.put(src,-1);
        q.offer(src);
        visited[src] = true;
         
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj.get(u)){
                if(visited[v] == true && map.get(u) != v){
                    return true;
                }
                else if(!visited[v]){
                    q.offer(v);
                    map.put(v,u);
                    visited[v] = true;
                 }
             }
         }
         
        return false;
    }
}
