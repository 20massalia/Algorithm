function bfs(n, edges, start) {
  // 인접 리스트
  const adj = Array.from({ length: n }, () => []);
    
  for (const [u1, v1] of edges) {
    const u = u1 - 1, v = v1 - 1;
    adj[u].push(v);
    adj[v].push(u);
  }

  // 거리/큐
  const dist = Array(n).fill(-1);
  const queue = [];

  dist[start - 1] = 0;
  queue.push(start - 1);

  // BFS
  for (let head = 0; head < queue.length; head++) {
    const u = queue[head];
      
    for (const v of adj[u]) {
      if (dist[v] !== -1) continue; // 이미 방문함
      dist[v] = dist[u] + 1;
      queue.push(v);
    }
  }
    
  return dist; // start로부터 각 정점까지의 최단거리
}

function solution(n, roads, sources, destination) {
  const result = bfs(n, roads, destination);
    
  return sources.map(s => result[s - 1]);
}
