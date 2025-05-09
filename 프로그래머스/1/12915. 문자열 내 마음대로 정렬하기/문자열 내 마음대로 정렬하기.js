function solution(strings, n) {
    const mapped = new Map(
        strings.map(str => [str, str[n]])
    );
    
    const sorted = [...mapped.entries()]
        .sort((a, b) => {
            if (a[1] === b[1])
                return a[0].localeCompare(b[0]);
            return a[1].localeCompare(b[1]);
        })
        .map(entry => entry[0]);
    
    return sorted;
}