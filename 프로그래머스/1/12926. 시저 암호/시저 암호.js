function solution(s, n) {
    let result = '';

    for (let i = 0; i < s.length; i++) {
        const char = s[i];

        if (char >= 'A' && char <= 'Z') {
            const shifted = String.fromCharCode((char.charCodeAt(0) - 65 + n) % 26 + 65);
            result += shifted;
        } else if (char >= 'a' && char <= 'z') {
            const shifted = String.fromCharCode((char.charCodeAt(0) - 97 + n) % 26 + 97);
            result += shifted;
        } else {
            result += char;
        }
    }

    return result;
}
