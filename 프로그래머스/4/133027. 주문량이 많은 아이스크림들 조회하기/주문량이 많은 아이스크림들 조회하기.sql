SELECT f.FLAVOR
FROM FIRST_HALF f

-- JULY를 FLAVOR로 그룹핑해서 7월 주문량을 맛별 합계로 만듦
LEFT JOIN(
    SELECT FLAVOR, -- 조인 기준이 될 맛
    SUM(TOTAL_ORDER) AS JULY_ORDER -- 7월 주문량을 맛별로 합산한 값
    FROM JULY
    GROUP BY FLAVOR -- 맛 기준으로 그룹핑
) j -- 위 서브쿼리 결과를 j로 별칭 지정
ON f.FLAVOR = j.FLAVOR -- 상반기(f)와 7월 합계(j)를 FLAVOR로 연결

-- 정렬 기준: 상반기 주문량 + 7월 주문량
-- 7월에 주문이 없는 맛은 j.JULY_ORDER가 NULL이므로 0으로 바꿔서 더함
ORDER BY f.TOTAL_ORDER + IFNULL(j.JULY_ORDER, 0) DESC

LIMIT 3;