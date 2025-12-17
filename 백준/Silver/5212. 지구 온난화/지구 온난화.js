// https://www.acmicpc.net/problem/5212
let fs = require("fs");
const input = fs.readFileSync("/dev/stdin", "utf8").trim().split("\n");

const [R, C] = input[0].trim().split(" ").map(Number);
const map = input.slice(1, 1 + R).map((line) => line.trim().split(""));

const directions = [
  [-1, 0], // 상
  [1, 0], // 하
  [0, -1], // 좌
  [0, 1], // 우
];

const next = map.map((row) => row.slice());

for (let i = 0; i < R; i++) {
  for (let j = 0; j < C; j++) {
    if (map[i][j] !== "X") continue;

    let sea = 0;

    for (const [dx, dy] of directions) {
      const nx = i + dx,
        ny = j + dy;
      // 지도 밖은 바다
      if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
        sea++;
        continue;
      }
      if (map[nx][ny] === ".") sea++;
    }

    if (sea >= 3) next[i][j] = "."; // 가라앉음
  }
}

// 최소 직사각형 출력
let rmin = R,
  rmax = -1,
  cmin = C,
  cmax = -1;
for (let i = 0; i < R; i++) {
  for (let j = 0; j < C; j++) {
    if (next[i][j] === "X") {
      if (i < rmin) rmin = i;
      if (i > rmax) rmax = i;
      if (j < cmin) cmin = j;
      if (j > cmax) cmax = j;
    }
  }
}

if (rmax === -1) {
  console.log(".");
} else {
  let out = [];
  for (let i = rmin; i <= rmax; i++) {
    out.push(next[i].slice(cmin, cmax + 1).join(""));
  }
  console.log(out.join("\n"));
}
