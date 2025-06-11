function solution(priorities, location) {
    const queue = priorities.map((priority, index) => [priority, index]);
    const sequence = [];

    while (queue.length > 0) {
        const current = queue.shift();
        if (queue.some(item => item[0] > current[0])) {
            queue.push(current);
        } else {
            sequence.push(current);
        }
    }

    return sequence.findIndex(item => item[1] === location) + 1;
}
