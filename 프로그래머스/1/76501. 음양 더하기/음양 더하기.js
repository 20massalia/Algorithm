function solution(absolutes, signs) {
    return absolutes.reduce((sum, val, i) => {
        return sum + (signs[i] ? val : -val);
    }, 0);
}