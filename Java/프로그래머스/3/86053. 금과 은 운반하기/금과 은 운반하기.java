class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        // 이분 탐색 사용
        long left = 0L, right = 400000000000000L;
        long answer = right;
        
        while(left <= right) {
            long mid = left + (right - left) / 2;
            if (canDeliver(mid, a, b, g, s, w, t)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean canDeliver(long T, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long totalGold = 0, totalSilver = 0, totalMinerals = 0;
        
        for (int i = 0; i < g.length; i++) {
            // 최대 왕복 횟수, 마지막 편도 여부 체크
            long maxTrips = T / (2L * t[i]);
            long lastTrip = T % (2L * t[i]) >= t[i] ? 1 : 0;
            
            // 최대 운반 무게 체크
            long maxWeight = maxTrips * w[i] + (lastTrip * w[i]);
            
            long eachGold = Math.min(g[i], maxWeight);
            long eachSilver = Math.min(s[i], maxWeight);
            long eachTotal = Math.min(g[i] + s[i], maxWeight);
            
            totalGold += eachGold;
            totalSilver += eachSilver;
            totalMinerals += eachTotal;
        }
        
        // 금 할당량 가능한지, 은 할당량 가능한 지, 총 할당량 되는 지
        return (totalGold >= a) && (totalSilver >= b) && (totalMinerals >= (a + b));
        
    }


}
