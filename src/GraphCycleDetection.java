// this is approach is using the dfs traversal.

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean []visited = new boolean[V];
        for(int i= 0; i <V; i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean dfs(int src , ArrayList<ArrayList<Integer>> adj,boolean []visited , int parent){
        visited[src] = true;
        
        for(int v : adj.get(src)){
            if(!visited[v]){
                if(dfs(v, adj, visited, src)){
                    return true;
                }
            }else if(parent != v){
                return true;
            }
        }
        
        return false;
    }
    
    
}
