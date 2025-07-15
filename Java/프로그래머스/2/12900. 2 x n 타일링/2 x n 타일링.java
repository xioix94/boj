class Solution {
    public int solution(int n) {
        final int MOD = 1000000007;
        int[] temp = new int[n + 1];
        temp[1] = 1;
        temp[2] = 2;
        for (int i = 3; i <= n; i++) {
            temp[i] = (temp[i - 1] + temp[i - 2]) % MOD;
        }
        
        return temp[n];
    }
}