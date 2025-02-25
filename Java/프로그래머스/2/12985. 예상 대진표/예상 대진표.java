class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        int aGroup = selectGroup(a);
        int bGroup = selectGroup(b);
        while(true) {
            if (aGroup == bGroup) {
                return round;
            }
            
            if (aGroup != 1) {
                aGroup = (aGroup + 1) / 2;
            }
            
            if (bGroup != 1) {
                bGroup = (bGroup + 1) / 2;
            }
            
            round += 1;
        }
    }
    
    public int selectGroup(int n) {
        if (n % 2 != 0) {
            n += 1;
        }
        
        return n / 2;
    }
}