function solution(X, Y) {
    const xCount = Array(10).fill(0);
    const yCount = Array(10).fill(0);

    for (let digit of X) xCount[+digit]++;
    for (let digit of Y) yCount[+digit]++;

    let result = "";

    for (let i = 9; i >= 0; i--) {
        const count = Math.min(xCount[i], yCount[i]);
        result += String(i).repeat(count);
    }

    if (result === "") return "-1";
    if (result[0] === "0") return "0";

    return result;
}