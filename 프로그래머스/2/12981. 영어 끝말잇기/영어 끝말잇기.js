function solution(n, words) {
    var answer = [0, 0];
    let spokenWords = new Set();

    for (let i = 0; i < words.length; i++) {
        let currentWord = words[i];

        if (i > 0) {
            let prevWord = words[i - 1];
            if (prevWord[prevWord.length - 1] !== currentWord[0] || spokenWords.has(currentWord)) {
                answer = [(i % n) + 1, Math.floor(i / n) + 1];
                break;
            }
        }

        spokenWords.add(currentWord);
    }

    return answer;
}
