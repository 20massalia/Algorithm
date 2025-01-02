function solution(park, routes) {
    const row = park.length;
    const col = park[0].length;
    
    let start = null;

    for (let i = 0; i < row; i++) {
        for (let j = 0; j < col; j++) {
            if (park[i][j] === "S") {
                start = [i, j];
                break;
            }
        }
        if (start) break;
    }

    routes.forEach(route => {
        const [direction, stepsStr] = route.split(" ");
        const steps = parseInt(stepsStr, 10);

        let isBlocked = false;

        switch (direction) {
            case "N":
                if (start[0] - steps >= 0) {
                    for (let i = 1; i <= steps; i++) {
                        if (park[start[0] - i][start[1]] === "X") {
                            isBlocked = true;
                            break;
                        }
                    }
                    if (!isBlocked) start[0] -= steps;
                }
                break;
            case "E":
                if (start[1] + steps < col) {
                    for (let i = 1; i <= steps; i++) {
                        if (park[start[0]][start[1] + i] === "X") {
                            isBlocked = true;
                            break;
                        }
                    }
                    if (!isBlocked) start[1] += steps;
                }
                break;
            case "S":
                if (start[0] + steps < row) {
                    for (let i = 1; i <= steps; i++) {
                        if (park[start[0] + i][start[1]] === "X") {
                            isBlocked = true;
                            break;
                        }
                    }
                    if (!isBlocked) start[0] += steps;
                }
                break;
            case "W":
                if (start[1] - steps >= 0) {
                    for (let i = 1; i <= steps; i++) {
                        if (park[start[0]][start[1] - i] === "X") {
                            isBlocked = true;
                            break;
                        }
                    }
                    if (!isBlocked) start[1] -= steps;
                }
                break;
        }
    });

    return start;
}
