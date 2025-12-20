let fs = require("fs");
const input = fs.readFileSync("/dev/stdin", "utf8").trim().split("\n");

// 시간을 분 단위 정수로 변환해 비교할 것
function toMin(hhmm) {
  const [hh, mm] = hhmm.split(":").map(Number);
  return hh * 60 + mm;
}

// 개강총회를 시작한 시간 S, 개강총회를 끝낸 시간 E, 개강총회 스트리밍을 끝낸 시간 Q
const [Ss, Ee, Qq] = input[0].trim().split(/\s+/);
const S = toMin(Ss);
const E = toMin(Ee);
const Q = toMin(Qq);

const pre = new Set();
const result = new Set();

for (let i = 1; i < input.length; i++) {
  const [tStr, nick] = input[i].trim().split(/\s+/);
  const t = toMin(tStr);

  // 개강총회를 시작하기 전에, 학회원의 입장 확인 여부를 확인
  if (t <= S) {
    pre.add(nick);
    continue;
  }

  // 개강총회를 끝내고 나서, 스트리밍을 끝낼 때까지 학회원의 퇴장 확인 여부를 확인
  // E ~ Q 사이: pre에 이미 있으면 result에 추가
  if (E <= t && t <= Q && pre.has(nick)) {
    result.add(nick);
  }
}

console.log(result.size);