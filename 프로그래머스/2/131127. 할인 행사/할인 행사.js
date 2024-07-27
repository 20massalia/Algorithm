function solution(want, number, discount) {
    const wantMap = new Map();
    const currentMap = new Map();
    let result = 0;
    
    for (let i = 0; i < want.length; i++) {
        wantMap.set(want[i], number[i]);
    }

    for (let i = 0; i < 10; i++) {
        currentMap.set(discount[i], (currentMap.get(discount[i]) || 0) + 1);
    }

    const isMatch = () => {
        for (const [key, value] of wantMap.entries()) {
            if (currentMap.get(key) !== value) {
                return false;
            }
        }
        return true;
    };

    if (isMatch()) {
        result++;
    }

    for (let i = 10; i < discount.length; i++) {
        const newItem = discount[i];
        currentMap.set(newItem, (currentMap.get(newItem) || 0) + 1);
        
        const oldItem = discount[i - 10];
        if (currentMap.get(oldItem) === 1) {
            currentMap.delete(oldItem);
        } else {
            currentMap.set(oldItem, currentMap.get(oldItem) - 1);
        }

        if (isMatch()) {
            result++;
        }
    }

    return result;
}