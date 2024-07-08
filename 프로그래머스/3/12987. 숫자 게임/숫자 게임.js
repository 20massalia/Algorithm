function solution(A, B) {
  var answer = 0;

  A.sort((a, b) => a - b);
  B.sort((a, b) => a - b);
    
  let j = 0;
    
  for (let i = 0; i < A.length; i++) {
    if (A[j] < B[i]) {
      j++;
      answer++;
    }
  }
  return answer;
}