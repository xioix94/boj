class Solution {
    public int dfs(int k, int[][] dungeons) {
        int count = 0;
        
        for (int[] d : dungeons) {
            int a = d[0], b = d[1];
            if (k >= a) {
                d[0] = 9999;
                count = Math.max(count, 1 + dfs(k - b, dungeons));
                d[0] = a;
            }
        }
        
        return count;
    }
    
    public int solution(int k, int[][] dungeons) {
        int answer = dfs(k, dungeons);
        return answer;
    }
}