function solution(s) {
    let cnt = 0;
    let x = s[0];
    let numOfX = 0;
    let numOfNotX = 0;

    for (let i = 0; i < s.length; i++) {
        const ch = s[i];
        if (numOfX === 0 && numOfNotX === 0) {
            x = ch;
        }

        if (ch === x) {
            numOfX++;
        } else {
            numOfNotX++;
        }

        if (numOfX === numOfNotX) {
            cnt++;
            numOfX = 0;
            numOfNotX = 0;
        }
    }

    if (numOfX !== 0 || numOfNotX !== 0) {
        cnt++;
    }

    return cnt;
}
