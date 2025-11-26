function solution(k, ranges) {
    let result = [];
    
    // 우박 수열 값 계산
    const vals = [k];
    while (k !== 1) {
        k = (k % 2 === 0) ? (k / 2) : (k * 3 + 1);
        vals.push(k);
    }
    
    
    // 각 구간 넓이 계산
    const n = vals.length - 1;
    const areas = new Array(n);
    
    for (let i = 0; i < n; i++) {
        areas[i] = (vals[i] + vals[i + 1]) / 2;
    }
    
    // 누적합
    const prefix = new Array(n + 1);
    prefix[0] = 0;
    
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + areas[i];
    }
    
    for (const r of ranges) {
        if (r[0] === 0 && r[1] === 0) {
          result.push(prefix[n]);
          continue;
        }
        
        const a = r[0];
        const b = n + r[1];
        
        if (a > b) {
            result.push(-1.0);
        } else if (a === b) {
            result.push(0.0);
        } else {
            result.push(prefix[b] - prefix[a]);
        }
    }
    
    return result;
}