function solution(array, commands) {
    let answer = [];
    
    for (const command of commands) { 
        let temp = array.slice(command[0] - 1, command[1]); 
        temp.sort((a, b) => a - b);
        answer.push(temp[command[2] - 1]);
    }
    
    return answer;
}
