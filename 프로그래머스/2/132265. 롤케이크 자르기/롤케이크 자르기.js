function solution(topping) {
    const leftMap = new Map();
    const rightMap = new Map();

    for (const t of topping) {
        rightMap.set(t, (rightMap.get(t) || 0) + 1);
    }

    let count = 0;

    for (let i = 0; i < topping.length - 1; i++) {
        const t = topping[i];
        leftMap.set(t, (leftMap.get(t) || 0) + 1);
        rightMap.set(t, rightMap.get(t) - 1);
        if (rightMap.get(t) === 0) {
            rightMap.delete(t);
        }
        if (leftMap.size === rightMap.size) {
            count++;
        }
    }

    return count;
}
