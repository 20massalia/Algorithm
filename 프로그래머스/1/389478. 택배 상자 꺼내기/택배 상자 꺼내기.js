// num 바로 위 칸의 번호를 반환, 없으면 -1
function getUpperBoxNum(n, w, num) {
  const R = Math.ceil(n / w);
  const r = Math.ceil(num / w);

  if (r === R) return -1;

  // 현재 층에서의 열 c
  const idx = (num - 1) % w;
  const c = (r % 2 === 1) ? idx : (w - 1 - idx);

  const r2 = r + 1;
  const topCount = n - (R - 1) * w;

  if (r2 < R) {
  } else {
    if (topCount < w) {
      if (R % 2 === 1) {
        // 맨 윗층이 홀수층
        if (c > topCount - 1) return -1;
      } else {
        // 맨 윗층이 짝수층
        if (c < w - topCount) return -1;
      }
    }
  }

  if (r2 % 2 === 1) {
    // 좌->우
    return (r2 - 1) * w + (c + 1);
  } else {
    // 우->좌
    return r2 * w - c;
  }
}

function countBoxes(n, num, w, count) {
  const upper = getUpperBoxNum(n, w, num);
  if (upper === -1) return count;
  return countBoxes(n, upper, w, count + 1);
}

function solution(n, w, num) {
  return countBoxes(n, num, w, 0) + 1;
}
