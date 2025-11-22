let fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().split("\n");

const num = Number(input[0].trim());

const board = input
  .slice(1, 1 + num) // 1번째 줄부터 n줄까지만 사용
  .map((line) => line.trim().split(" ").map(Number)); // 앞뒤 공백 제거 후 공백 기준으로 나누고, 숫자로 변환
// fs.readFileSync로 읽으면 전부 문자열이기 때문에 계산, 비교, 정렬 등을 위해 Number로 변환하는 과정이 필요함

const directions = [
  [-1, 0], // up
  [1, 0], // down
  [0, -1], // left
  [0, 1], // right
];

const dp = Array.from({ length: num }, () => Array(num).fill(0));

function dfs(x, y) {
  if (dp[x][y] !== 0) return dp[x][y]; // 메모이제이션

  let best = 1;

  for (const [dx, dy] of directions) {
    const nx = x + dx;
    const ny = y + dy;

    if (nx < 0 || ny < 0 || nx >= num || ny >= num) continue; // 범위 체크

    if (board[nx][ny] > board[x][y]) {
      // 더 큰 수일 경우
      const candidate = 1 + dfs(nx, ny); // 해당 수에 대해 dfs 진행
      if (candidate > best)
        // 여태 찾은 최장 경로보다 클 경우 교체
        best = candidate;
    }
  }

  dp[x][y] = best;
  return best;
}

let result = 0;
for (let i = 0; i < num; i++) {
  for (let j = 0; j < num; j++) {
    result = Math.max(result, dfs(i, j));
  }
}

console.log(result);