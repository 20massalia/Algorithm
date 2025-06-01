function solution(spell, dic) {
    let cnt = 0;
    const pattern = `^(?!.*(.).*\\1)[${spell.join("")}]{${spell.length}}$`;
    const regex = new RegExp(pattern);

    for (const d of dic) {
        if (regex.test(d)) cnt++;
    }
    
    return cnt === 0 ? 2 : cnt;
}