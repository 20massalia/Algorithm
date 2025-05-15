function solution(array) {
    let map = new Map();

    for (let i = 0; i < array.length; i++) {
        if (map.has(array[i])) {
            map.set(array[i], map.get(array[i]) + 1);
        } else {
            map.set(array[i], 1);
        }
    }

    let maxCount = 0;
    let result = -1;
    let isDuplicate = false;

    for (const [key, value] of map.entries()) {
        if (value > maxCount) {
            maxCount = value;
            result = key;
            isDuplicate = false;
        } else if (value === maxCount) {
            isDuplicate = true;
        }
    }

    return isDuplicate ? -1 : result;
}
