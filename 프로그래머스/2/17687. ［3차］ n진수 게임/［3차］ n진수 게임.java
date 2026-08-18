class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder fullString = new StringBuilder();
        int num = 0;
        
        while (fullString.length() < t * m) {
            fullString.append(Integer.toString(num, n).toUpperCase());
            num++;
        }
        
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < fullString.length(); i++) {
            if (i % m == p - 1) answer.append(fullString.charAt(i));
            if (answer.length() == t) break;
        }
        
        return answer.toString();
    }
}