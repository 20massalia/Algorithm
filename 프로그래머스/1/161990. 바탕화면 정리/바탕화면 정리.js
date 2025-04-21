function solution(wallpaper) {
    let rowMin = wallpaper.length;
    let rowMax = 0;
    let colMin = wallpaper[0].length;
    let colMax = 0;

    wallpaper.forEach((row, i) => {
        [...row].forEach((cell, j) => {
            if (cell === "#") {
                rowMin = Math.min(rowMin, i);
                rowMax = Math.max(rowMax, i + 1);
                colMin = Math.min(colMin, j);
                colMax = Math.max(colMax, j + 1);
            }
        });
    });

    return [rowMin, colMin, rowMax, colMax];
}
