function solution(a, b) {
  const concatenated = parseInt(`${a}${b}`, 10);
  const multiplied = 2 * a * b;
  return concatenated > multiplied ? concatenated : multiplied;
}