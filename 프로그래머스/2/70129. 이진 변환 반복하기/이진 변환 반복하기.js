function solution(s) {
    let count = 0;
    let removedZeros = 0;
    
    while (s !== "1") {
        let zerosCount = s.split('0').length - 1;
        removedZeros += zerosCount;
        
        let ones = s.replace(/0/g, '');
        s = ones.length.toString(2);
        count++;
    }
    
    return [count, removedZeros];
}
