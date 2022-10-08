class Solution
{
    static Stack<Integer> st = new Stack<>();
    static int []arr;
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        arr = new int [V];
        boolean []visited = new boolean[V];
        for(int i = 0; i<V; i++){
            if(!visited[i]){
                dfs(i,adj, visited);
            }
        }
        int idx = 0;
        while(!st.isEmpty()){
            arr[idx] = st.pop();
            idx++;
        }
        return arr;
        
    }
    
    public static void dfs(int v, ArrayList<ArrayList<Integer>> adj,boolean []visited ){
        visited[v] = true;
        
        for(int i : adj.get(v)){
            if(!visited[i]){
                dfs(i,adj,visited);
            }
        }
        
        st.push(v);
    }
}
