function solution(ingredient) {
    let answer = 0;
    let stack = [];
    
    for (const ing of ingredient) {
        stack.push(ing);
        if (stack.length >= 4) {
            const lastFour = stack.slice(-4);
            if (lastFour.join('') === '1231') {
                answer++;
                stack.splice(-4);
            }
        }
    }
    
    return answer;
}