function solution(n) {
    return fibonacci(n);
}

const fibonacci = (n) => {
    const dp = [];
    
    dp[0] = 0; 
    dp[1] = 1;
    
    for (let i = 2; i <= n; i++) {
        dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
    }
    
    return dp[n];
}
