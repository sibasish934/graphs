class Solution {
    public int removeStones(int[][] stones) {
        if(stones.length == 1){
            return 0;
        }
        int count = 0;
        boolean []visited = new boolean [stones.length];
        for(int i =0; i<stones.length; i++){
            visited[i] = false;
        }

        for(int i = 0; i< stones.length; i++){
            if(!visited[i]){
                count++;
                dfs(visited, stones, i);
            }
        }
        return stones.length - count;
    }

    public void dfs(boolean []visited, int [][] stones, int index){
        visited[index] = true;

        for(int i = 0; i<stones.length; i++){
            if(!visited[i] && checkRowAndCol(stones[index], stones[i])){
                dfs(visited, stones, i);
            }
        }
    }

    public boolean checkRowAndCol(int[]stone1, int []stone2){
        if(stone1[0] == stone2[0] || stone1[1] == stone2[1]){
            return true;
        }
        return false;
    }
}
