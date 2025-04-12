function solution(x) {
    let sum = 0;
    
    for (const num of x.toString()) {
        sum += Number(num);
    }
    
    return x % sum === 0;
}
