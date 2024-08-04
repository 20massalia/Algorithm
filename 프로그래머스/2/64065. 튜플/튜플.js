function solution(s) {
    let answer = [];
    
    s = s.replace(/{/g, '[').replace(/}/g, ']');
    s = JSON.parse(s);
    s.sort((a, b) => a.length - b.length);
    
    for(let i = 0; i < s.length; i++) {
        for(let j = 0; j < s[i].length; j++) {
            if(!answer.includes(s[i][j]))
                answer.push(s[i][j]);
        }
    }
    
    return answer;
}