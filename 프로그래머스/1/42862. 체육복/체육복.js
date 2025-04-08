function solution(n, lost, reserve) {
    let realLost = lost.filter(l => !reserve.includes(l));
    let realReserve = reserve.filter(r => !lost.includes(r));
        
    realLost.sort((a, b) => a - b);
    realReserve.sort((a, b) => a - b);
    
    for (let i = 0; i < realLost.length; i++) {
        let student = realLost[i];
        let index = realReserve.findIndex(r => Math.abs(r - student) === 1);
        if (index !== -1) {
            realReserve.splice(index, 1);
            realLost[i] = -1;
        }
    }
    
    return n - realLost.filter(l => l !== -1).length;
}