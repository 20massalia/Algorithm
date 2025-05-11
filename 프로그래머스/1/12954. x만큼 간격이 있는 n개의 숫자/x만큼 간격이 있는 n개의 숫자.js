function solution(x, n) {
    const answer = [];
    let i = 1;

    while (answer.length < n) {
        answer.push(x * i++);
    }

    return answer;
}
