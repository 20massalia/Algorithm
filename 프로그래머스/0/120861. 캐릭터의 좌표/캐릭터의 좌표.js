function solution(keyinput, board) {
    let pos = [0, 0];
    const limitX = Math.floor(board[0] / 2);
    const limitY = Math.floor(board[1] / 2);
    const moves = {
        up:    [0, 1],
        down:  [0, -1],
        left:  [-1, 0],
        right: [1, 0],
    };

    for (const key of keyinput) {
        const [dx, dy] = moves[key];
        const [nextX, nextY] = [pos[0] + dx, pos[1] + dy];

        if (Math.abs(nextX) <= limitX && Math.abs(nextY) <= limitY) {
            pos = [nextX, nextY];
        }
    }

    return pos;
}
