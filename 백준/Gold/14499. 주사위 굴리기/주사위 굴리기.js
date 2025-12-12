// https://www.acmicpc.net/problem/14499
let fs = require("fs");
const input = fs.readFileSync("/dev/stdin", "utf8").trim().split("\n");

const first = input[0].trim().split(/\s+/).map(Number);
const N = first[0],
  M = first[1],
  K = first[4];
let x = first[2],
  y = first[3];
const map = Array.from({ length: N }, (_, i) =>
  input[1 + i].trim().split(/\s+/).map(Number)
);
const orders = input[N + 1].trim().split(" ").map(Number);

// 주사위 상태: top, bottom, north, south, west, east
let dice = [0, 0, 0, 0, 0, 0];

// 동(1) 굴리기
function rollEast() {
  const [t, b, n, s, w, e] = dice;
  dice = [w, e, n, s, b, t];
}

// 서(2) 굴리기
function rollWest() {
  const [t, b, n, s, w, e] = dice;
  dice = [e, w, n, s, t, b];
}

// 북(3) 굴리기
function rollNorth() {
  const [t, b, n, s, w, e] = dice;
  dice = [s, n, t, b, w, e];
}

// 남(4) 굴리기
function rollSouth() {
  const [t, b, n, s, w, e] = dice;
  dice = [n, s, b, t, w, e];
}

// 동서북남 순
const dx = [0, 0, -1, 1];
const dy = [1, -1, 0, 0];

for (let i = 0; i < K; i++) {
  const dir = orders[i];
  const nx = x + dx[dir - 1],
    ny = y + dy[dir - 1];

  if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 경계 밖 - 무시

  // 회전
  if (dir === 1) rollEast();
  else if (dir === 2) rollWest();
  else if (dir === 3) rollNorth();
  else rollSouth();

  // 바닥값을 칸으로 복사
  if (map[nx][ny] === 0) map[nx][ny] = dice[1];
  // 칸값을 바닥으로 복사, 칸은 0
  else {
    dice[1] = map[nx][ny];
    map[nx][ny] = 0;
  }

  // 위치 갱신
  x = nx;
  y = ny;

  console.log(dice[0]);
}
