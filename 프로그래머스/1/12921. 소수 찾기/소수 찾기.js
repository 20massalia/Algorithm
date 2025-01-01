function solution(n) {
  const isPrime = Array(n + 1).fill(true);
  isPrime[0] = isPrime[1] = false;

  for (let j = 2; j * j <= n; j++) {
    if (isPrime[j]) {
      for (let k = j * j; k <= n; k += j) {
        isPrime[k] = false;
      }
    }
  }

  return isPrime.filter(Boolean).length;
}