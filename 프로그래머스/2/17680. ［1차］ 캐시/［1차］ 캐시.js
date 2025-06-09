function solution(cacheSize, cities) {
    let answer = 0;
    let cache = [];
    
    for (const city of cities) {
        const cityLower = city.toLowerCase();
        const idx = cache.indexOf(cityLower);
        
        if (idx !== -1) { // hit
            cache.splice(idx, 1);
            cache.push(cityLower);
            answer += 1;
        } else { // miss
            if (cacheSize > 0 && cache.length >= cacheSize) cache.shift();
            if (cacheSize > 0) cache.push(cityLower);
            answer += 5;
        }
    }
    
    return answer;
}