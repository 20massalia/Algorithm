function solution(left, right) {
    let answer = 0;

    for (let i = left; i <= right; i++) {
        const isPerfectSquare = Number.isInteger(Math.sqrt(i));
        answer += isPerfectSquare ? -i : i;
    }

    return answer;
}
