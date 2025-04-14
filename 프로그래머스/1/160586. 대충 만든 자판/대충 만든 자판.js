function solution(keymap, targets) {
    let result = [];
    let charMap = new Map();

    for (let i = 0; i < keymap.length; i++) {
        for (let j = 0; j < keymap[i].length; j++) {
            const ch = keymap[i][j];
            const cost = j + 1;

            if (!charMap.has(ch))
                charMap.set(ch, cost);
            else
                charMap.set(ch, Math.min(charMap.get(ch), cost));
        }
    }

    for (const target of targets) {
        let sum = 0;
        let valid = true;

        for (const ch of target) {
            if (charMap.has(ch))
                sum += charMap.get(ch);
            else {
                valid = false;
                break;
            }
        }

        result.push(valid ? sum : -1);
    }

    return result;
}