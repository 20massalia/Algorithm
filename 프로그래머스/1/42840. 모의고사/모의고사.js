function solution(answers) {
    let oneCnt = 0;
    let twoCnt = 0;
    let threeCnt = 0;

    let one = [1, 2, 3, 4, 5];
    let two = [2, 1, 2, 3, 2, 4, 2, 5];
    let three = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

    for (let i = 0; i < answers.length; i++) {
        if (answers[i] === one[i % one.length]) oneCnt++;
        if (answers[i] === two[i % two.length]) twoCnt++;
        if (answers[i] === three[i % three.length]) threeCnt++;
    }

    const maxScore = Math.max(oneCnt, twoCnt, threeCnt);
    const result = [];

    if (oneCnt === maxScore) result.push(1);
    if (twoCnt === maxScore) result.push(2);
    if (threeCnt === maxScore) result.push(3);

    return result;
}
