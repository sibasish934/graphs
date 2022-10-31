class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean []visited = new boolean[V];
        boolean []resStack = new boolean[V];
        
        for(int i = 0; i<V; i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,resStack)){
                    return true;
                }
            }
        }
        return false;
        
    }
    
    
    public boolean dfs(int v,ArrayList<ArrayList<Integer>> adj, boolean []visited, boolean []resStack){
        visited[v] = true;
        resStack[v] = true;
        for(int i : adj.get(v)){
            if(!visited[i]){
                if(dfs(i, adj,visited, resStack)){
                    return true;
                }
            }else if(resStack[i]){
                return true;
            }
        }
        
        resStack[v] = false;
        return false;
    }
}
