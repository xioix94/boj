class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = calculate(numbers, target);
        return answer;
    }
    
    public int calculate(int[] numbers, int target) {
        int count = 0;
        return calculateRecursive(numbers, 0, target, count, 0);
    }
    
    public int calculateRecursive(int[] numbers, int index, int target, int count, int sum) {
        
        // 마지막인 경우 종료
        if (index == numbers.length - 1) {
            
            // 요소 더하는 경우
            if (sum + numbers[index] == target) {
                count++;
            }

            // 요소 빼는 경우
            if (sum - numbers[index] == target) {
                count++;
            }
            
            return count;
        }
        
        // 마지막 요소 아니라면 함수 재호출
        return calculateRecursive(numbers, index + 1, target, count, sum + numbers[index]) + calculateRecursive(numbers, index + 1, target, count, sum - numbers[index]);
    }
}