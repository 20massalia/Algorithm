function solution(maps) {
  let answer = 0;
  const row = maps.length;
  const col = maps[0].length;

  const di = [0, 0, 1, -1];
  const dj = [1, -1, 0, 0];

  const BFS = (i, j, goal) => {
    let visited = Array(row)
      .fill()
      .map(() => Array(col).fill(false));

    let queue = [];
    visited[i][j] = true;
    queue.push([i, j, 0]);

    while (queue.length > 0) {
      const [ii, jj, cnt] = queue.shift();
      if (maps[ii][jj] === goal) {
        return cnt;
      }

      for (let i = 0; i < 4; i++) {
        const ni = ii + di[i];
        const nj = jj + dj[i];
          
        if (
          ni >= 0 &&
          ni < row &&
          nj >= 0 &&
          nj < col &&
          maps[ni][nj] !== "X" &&
          !visited[ni][nj]
        ) {
          visited[ni][nj] = true;
          queue.push([ni, nj, cnt + 1]);
        }
      }
    }
  };

  for (let i = 0; i < row; i++) {
    for (let j = 0; j < col; j++) {
      if (maps[i][j] === "S") {
        answer += BFS(i, j, "L");
      } else if (maps[i][j] === "L") {
        answer += BFS(i, j, "E");
      } else continue;
    }
  }

  return answer ? answer : -1;
}