function solution(k, dungeons) {
    let maxCnt = 0;
    
    function dfs(currentK, visited, cnt) {
        maxCnt = Math.max(maxCnt, cnt);
        
        for (let i = 0; i < dungeons.length; i++) {
            const [minFatigue, useFatigue] = dungeons[i];
            
            if (!visited[i] && currentK >= minFatigue) {
                visited[i] = true;
                dfs(currentK - useFatigue, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    dfs(k, Array(dungeons.length).fill(false), 0);
    
    return maxCnt;
}