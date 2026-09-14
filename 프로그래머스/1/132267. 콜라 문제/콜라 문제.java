class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int coke = n;
        
        while (coke >= a) {
            int mart = coke / a;
            coke = coke - (mart * a) + (mart * b);
            answer += mart * b;
        }
        
        return answer;
    }
}