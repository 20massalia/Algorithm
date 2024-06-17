const path = process.platform === "linux" ? "/dev/stdin" : "input.txt"; // 리눅스로 테스트할 땐 따로 설정해주어야 합니다.
const [n] = require("fs")
  .readFileSync(path)
  .toString()
  .trim()
  .split("\n");

function solution(n) {
  return n % 2 === 0 ? 'CY' : 'SK';
}

const answer = solution(n);
console.log(answer);