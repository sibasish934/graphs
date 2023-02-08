class Solution {
    public int jump(int[] nums) {
        /* This approach is using the graphs */
        Queue <Integer> q = new LinkedList<>();
        q.offer(0);
        boolean [] visited = new boolean [nums.length];
        visited[0] = true;
        int jumps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while( size-- > 0){
                int i = q.poll();
                if( i == nums.length-1){
                    return jumps;
                }

                for(int j=nums[i]; j>=0; j--){
                    int newIdx = i+j;
                    if(newIdx < nums.length && !visited[newIdx]){
                        visited[newIdx] = true;
                        q.offer(newIdx);
                    }
                }
            }
            jumps++;
        }
        return -1;
/* this solution is based on the dp approach of the problem */
        int pos = 0;
        int des = 0;
        int jump = 0;

        for(int i=0; i< nums.length-1; i++){
            des = Math.max(des, nums[i] + i);
            if(pos == i){
                jump++;
                pos = des;
            }
        }
        return jump;
    }
}
