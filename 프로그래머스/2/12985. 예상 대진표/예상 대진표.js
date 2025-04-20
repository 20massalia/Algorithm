function solution(n, a, b) {
    let cnt = 1;

    while (Math.abs(a - b) !== 1 || Math.max(a, b) % 2 !== 0) {
        a = Math.ceil(a / 2);
        b = Math.ceil(b / 2);
        cnt++;
    }

    return cnt;
}
