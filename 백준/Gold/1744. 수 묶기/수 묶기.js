let fs = require("fs");
const input = fs.readFileSync("/dev/stdin", "utf8").trim().split("\n");

const N = Number(input[0].trim());
const arr = input.slice(1, 1 + N).map((s) => Number(s.trim()));

const neg = []; // 음수
const pos = []; // 2 이상 양수
let ones = 0; // 1의 개수
let zeros = 0; // 0의 개수

for (const x of arr) {
  if (x <= -1) neg.push(x);
  else if (x === 0) zeros++;
  else if (x === 1) ones++;
  else pos.push(x);
}

// 음수는 오름차순(작은 음수부터 곱)
neg.sort((a, b) => a - b);
// 양수>1은 내림차순(큰 수부터 곱)
pos.sort((a, b) => b - a);

let result = 0;

// 양수
for (let i = 0; i + 1 < pos.length; i += 2) {
  result += pos[i] * pos[i + 1];
}
if (pos.length % 2 === 1) {
  result += pos[pos.length - 1]; // 남은 1개는 더하기
}

// 1들은 모두 더하기
result += ones;

// 음수
for (let i = 0; i + 1 < neg.length; i += 2) {
  result += neg[i] * neg[i + 1];
}
if (neg.length % 2 === 1) {
  // 음수가 하나 남았을 때 0이 있으면 0과 곱해 상쇄, 없으면 더함
  if (zeros === 0) result += neg[neg.length - 1];
}

console.log(result);