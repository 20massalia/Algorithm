function solution(s) {
    const words = s.split(' ');
    const transformedWords = words.map(word => {
        return word
            .split('')
            .map((char, index) => 
                index % 2 === 0 ? char.toUpperCase() : char.toLowerCase()
            )
            .join('');
    });
    
    return transformedWords.join(' ');
}
