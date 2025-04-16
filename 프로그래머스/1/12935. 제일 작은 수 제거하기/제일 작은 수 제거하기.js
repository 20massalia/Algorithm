function solution(arr) {
    const min = Math.min(...arr);
    const index = arr.indexOf(min);
    
    if (arr.length > 1) {
        arr.splice(index, 1);
        return arr;
    }
    else return [-1];
}