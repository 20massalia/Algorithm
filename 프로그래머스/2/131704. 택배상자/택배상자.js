function solution(order) {
    let truck = 1; // 첫 번째 박스는 무조건 싣는다
    let indicator = Number(order[0]) + 1; // 메인 벨트에서 다음에 나올 번호
    let belt = []; // 보조 벨트 (스택)

    // 1부터 order[0] - 1까지는 이미 보조 벨트에 쌓여 있다고 가정
    for (let num = 1; num < order[0]; num++) {
      belt.push(num);
    }

    // 두 번째 주문부터 순서대로 처리
    for (let i = 1; i < order.length; i++) {
      const target = order[i];

      if (target === indicator) {
        // 메인 벨트에서 바로 실을 수 있는 경우
        truck++;
        indicator++;
      } else if (target > indicator) {
        // 메인 벨트에서 여러 개를 보조 벨트로 보내고, target을 실는 경우
        for (let num = indicator; num < target; num++) {
          belt.push(num);
        }
        truck++;
        indicator = target + 1; // target까지 소비했으므로 다음 번호로 점프
      } else {
        // target < indicator 인 경우 → 이미 메인 벨트를 지나간 번호라 보조 벨트에서 찾아야 함
        const top = belt[belt.length - 1];

        if (target === top) {
          // 보조 벨트 맨 위와 같으면 실을 수 있음
          truck++;
          belt.pop();
        } else {
          // 보조 벨트에서도 못 찾으면 더 이상 이 이후 주문은 만족 불가
          return truck;
        }
      }
    }

    return truck;
}