function solution(score) {
    const averages = score.map(([a, b]) => (a + b) / 2);
    const sorted = [...averages].sort((a, b) => b - a);

    return averages.map(avg => sorted.indexOf(avg) + 1);
}
