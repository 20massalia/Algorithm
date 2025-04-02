function check(s) {
    const stack = [];

    for (let i = 0; i < s.length; i++) {
        const char = s[i];
        switch (char) {
            case '(':
            case '[':
            case '{':
                stack.push(char);
                break;
            case ')':
                if (stack.pop() !== '(') return false;
                break;
            case ']':
                if (stack.pop() !== '[') return false;
                break;
            case '}':
                if (stack.pop() !== '{') return false;
                break;
        }
    }

    return stack.length === 0;
}


function solution(s) {
    let cnt = 0;
    const arr = s.split('');

    for (let i = 0; i < s.length; i++) {
        if (check(arr)) cnt++;
        const first = arr.shift();
        arr.push(first);
    }

    return cnt;
}
