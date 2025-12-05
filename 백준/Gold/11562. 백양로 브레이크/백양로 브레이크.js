// https://www.acmicpc.net/problem/11562
let fs = require("fs");
const input = fs.readFileSync("/dev/stdin", "utf8").trim().split("\n");

const [N, M] = input[0].trim().split(" ").map(Number);

const dist = Array.from({ length: N }, () => Array(N).fill(Infinity));
for (let i = 0; i < N; i++) dist[i][i] = 0;

for (let i = 0; i < M; i++) {
  const [a, b, c] = input[i + 1].trim().split(/\s+/).map(Number);
  const u = a - 1,
    v = b - 1;

  if (dist[u][v] > 0) dist[u][v] = 0;

  if (c === 1) {
    // 양방향은 역방향도 비용 0
    if (dist[v][u] > 0) dist[v][u] = 0;
  } else {
    // 단방향의 역방향은 비용 1
    if (dist[v][u] > 1) dist[v][u] = 1;
  }
}

// 플로이드 워셜
for (let k = 0; k < N; k++) {
  for (let i = 0; i < N; i++) {
    if (dist[i][k] === Infinity) continue;
    for (let j = 0; j < N; j++) {
      if (dist[i][k] + dist[k][j] < dist[i][j])
        dist[i][j] = dist[i][k] + dist[k][j];
    }
  }
}

const K = Number(input[1 + M].trim());
let out = [];
for (let i = 0; i < K; i++) {
  const [s, t] = input[2 + M + i].trim().split(/\s+/).map(Number);
  out.push(String(dist[s - 1][t - 1]));
}

console.log(out.join("\n"));
