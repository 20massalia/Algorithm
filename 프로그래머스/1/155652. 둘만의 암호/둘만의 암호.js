function solution(s, skip, index) {
    const alphabet = [...'abcdefghijklmnopqrstuvwxyz'].filter((a) => !skip.includes(a));

    return s.split('').map((a) => alphabet[(alphabet.indexOf(a)+index) % alphabet.length]).join('');
}