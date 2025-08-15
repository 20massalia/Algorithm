const distance = (a, b) => Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);

function closerHand(left, right, destination, preferred) {
    let result = "";
    let nextLeft = left;
    let nextRight = right;

    const leftDist = distance(left, destination);
    const rightDist = distance(right, destination);

    if (leftDist < rightDist) {
        result = "L";
        nextLeft = [...destination];
    } else if (leftDist > rightDist) {
        result = "R";
        nextRight = [...destination];
    } else {
        if (preferred === "L") {
            result = "L";
            nextLeft = [...destination];
        } else {
            result = "R";
            nextRight = [...destination];
        }
    }

    return [result, nextLeft, nextRight];
}

function solution(numbers, hand) {
    const numberPad = {
        1: [0, 0], 2: [0, 1], 3: [0, 2],
        4: [1, 0], 5: [1, 1], 6: [1, 2],
        7: [2, 0], 8: [2, 1], 9: [2, 2],
        0: [3, 1]
    };

    const LEFT_COL = new Set([1, 4, 7]);
    const RIGHT_COL = new Set([3, 6, 9]);

    const preferred = hand === "left" ? "L" : "R";

    let result = "";
    let leftCursor = [3, 0];
    let rightCursor = [3, 2];

    for (const num of numbers) {
        if (LEFT_COL.has(num)) {
            result += "L";
            leftCursor = [...numberPad[num]];
        } else if (RIGHT_COL.has(num)) {
            result += "R";
            rightCursor = [...numberPad[num]];
        } else {
            const [ch, newLeft, newRight] =
                closerHand(leftCursor, rightCursor, numberPad[num], preferred);
            result += ch;
            leftCursor = newLeft;
            rightCursor = newRight;
        }
    }

    return result;
}