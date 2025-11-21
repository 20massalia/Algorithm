let fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");
const [N, K] = input[0].trim().split(" ").map(Number);
const board = input
  .slice(1, 1 + N)
  .map((line) => line.trim().split(" ").map(Number));
const [S, X, Y] = input[1 + N].trim().split(" ").map(Number);

const directions = [
  [-1, 0], // up
  [1, 0], // down
  [0, -1], // left
  [0, 1], // right
];

// 초기 바이러스 수집 후 오름차순 정렬
const initial = [];
for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    const v = board[i][j];
    if (v !== 0) initial.push([v, i, j, 0]);
  }
}

initial.sort((a, b) => a[0] - b[0]);

// BFS
const q = initial;
let head = 0;

while (head < q.length) {
  const [virus, x, y, time] = q[head++];

  if (time === S) break;

  for (const [dx, dy] of directions) {
    const nx = x + dx;
    const ny = y + dy;

    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

    if (board[nx][ny] !== 0) continue;

    board[nx][ny] = virus;
    q.push([virus, nx, ny, time + 1]);
  }
}

console.log(board[X - 1][Y - 1]);