// https://www.acmicpc.net/problem/2461
let fs = require("fs");
const input = fs.readFileSync("/dev/stdin", "utf8").trim().split("\n");

const [N, M] = input[0].trim().split(" ").map(Number);

// 능력치와 반 번호 짝 짓기
const pairs = [];
for (let i = 0; i < N; i++) {
  const nums = input[1 + i].trim().split(/\s+/).map(Number); // M개
  for (const v of nums) {
    pairs.push([v, i]);
  }
}

// value(능력치) 기준 정렬
pairs.sort((a, b) => a[0] - b[0]);

// 이후 슬라이딩 윈도우로 최소 구간 탐색
let result = Infinity;
const cnt = new Int32Array(N); // 반별 포함 개수
let covered = 0; // // 현재 윈도우에 포함된 서로 다른 반 수
let L = 0;

for (let R = 0; R < pairs.length; R++) {
  const clsR = pairs[R][1];

  // 새로운 반
  if (cnt[clsR]++ === 0) covered++;

  // 모든 반이 한 번 이상 들어온 순간, L을 최대한 줄여 최소 구간으로
  if (covered === N) {
    while (L <= R) {
      const clsL = pairs[L][1];
      if (cnt[clsL] > 1) {
        cnt[clsL]--;
        L++;
      } else break; // // 이 반 하나뿐이면 더 줄일 수 없음
    }
    const diff = pairs[R][0] - pairs[L][0];
    if (diff < result) result = diff;
  }
}

console.log(result);
