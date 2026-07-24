class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 0;
        
        for (int i = 1; i <= number; i++) {
            int divisor = div(i);     
            if (divisor > limit) sum += power;
            else sum += divisor;
        }
                
        return sum;
    }
    
    public int div(int N) {
        int count = 0;
        
        for (int i = 1; i * i <= N; i++) {
            if (i * i == N) count++;
            else if (N % i == 0) count += 2;
        }
        
        return count;
    }
}