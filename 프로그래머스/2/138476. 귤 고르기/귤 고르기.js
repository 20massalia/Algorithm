function solution(k, tangerine) {
    const freq = new Map();

    for(let i = 0; i < tangerine.length; i++) {
        const target = freq.get(tangerine[i]);
        freq.set(tangerine[i], target ? target + 1 : 1);
    }

    const val = Array.from(freq.values()).sort((a, b) => b - a);
    let count = 0;

    for(let i = 0; i < val.length; i++) {
        if (k <= 0) break;
        k -= val[i];
        count++;
    }

    return count;
}