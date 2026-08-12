class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int[][] dp = new int[n][4];
        
        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    if (dp[i - 1][k] > max) max = dp[i - 1][k];
                }
                
                dp[i][j] = max + land[i][j];
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (answer < dp[n - 1][i]) answer = dp[n - 1][i];
        }

        return answer;
    }
}