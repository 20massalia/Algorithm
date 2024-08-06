function itemsCount(items) {
    const counts = {};

    items.forEach(([item, category]) => {
        if (!counts[category])
          counts[category] = 0;
        counts[category]++;
    });

    return counts;
}

function solution(clothes) {
    const categoryCounts = itemsCount(clothes);
    let answer = 1;
    
    for (const category in categoryCounts) {
        answer *= categoryCounts[category] + 1;
    }

    return answer - 1;
}