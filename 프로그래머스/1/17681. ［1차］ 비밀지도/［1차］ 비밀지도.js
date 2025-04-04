function solution(n, arr1, arr2) {
    let answer = [];
    
    for (let i = 0; i < n; i++) {
        let bin1 = arr1[i].toString(2).padStart(n, '0');
        let bin2 = arr2[i].toString(2).padStart(n, '0');
        let line = "";
        
        for (let j = 0; j < n; j++) {
            if (bin1[j] === "0" && bin2[j] === "0") {
                line += " ";
            } else {
                line += "#";
            }
        }
        
        answer.push(line);
    }
    
    return answer;
}
