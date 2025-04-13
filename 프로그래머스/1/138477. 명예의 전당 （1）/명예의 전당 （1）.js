function solution(k, score) {
    let rank = [];
    let answer = [];

    for (const s of score) {
        rank.push(s);

        rank.sort((a, b) => b - a);
        if (rank.length > k) {
            rank.pop();
        }

        answer.push(rank[rank.length - 1]);
    }

    return answer;
}
