class Solution {
    public int solution(int n, int k) {
        String kStr = Integer.toString(n, k);
        String[] parts = kStr.split("0");
        
        int answer = 0;
        
        for (String part : parts) {
            if (part.isEmpty()) continue;
            
            long num = Long.parseLong(part);
            
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(long num) {
        if (num <= 1) return false;

        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}