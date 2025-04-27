function solution(my_string, queries) {
    let arr = my_string.split("");

    for (const querie of queries) {
        const [a, b] = querie;
        const reversed = arr.slice(a, b + 1).reverse();
        arr.splice(a, b - a + 1, ...reversed);
    }
    
    return arr.join("");
}
