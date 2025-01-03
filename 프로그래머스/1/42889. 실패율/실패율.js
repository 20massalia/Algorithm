function solution(N, stages) {
    let map = new Map();
    for (let i = 1; i <= N; i++)
        map.set(i, 0);
    
    for (let stage of stages) {
        if (stage <= N) {
            map.set(stage, map.get(stage) + 1);
        }
    }
    
    let count = 0;
    for (let i = 1; i <= N; i++) {
        let current = map.get(i);
        if (current === 0)
            map.set(i, 0);
        else
            map.set(i, current / (stages.length - count));
        count += current || 0;
    }
    
    let sorted = [...map.entries()].sort((a, b) => {
        if (b[1] === a[1])
            return a[0] - b[0];
        return b[1] - a[1];
    });
    
    return sorted.map(([key, _]) => key);
}

