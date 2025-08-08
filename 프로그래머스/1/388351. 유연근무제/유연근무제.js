function solution(schedules, timelogs, startday) {
    let validCount = 0;

    for (let i = 0; i < schedules.length; i++) {
        let isOnTime = true;
        let today = startday;
        const startHour = Math.floor(schedules[i] / 100);
        const startMin  = schedules[i] % 100;
        const deadlineMinutes = startHour * 60 + startMin + 10;

        for (let j = 0; j < timelogs[i].length; j++) {
            const dayOfWeek = ((today - 1) % 7) + 1;
            if (dayOfWeek === 6 || dayOfWeek === 7) {
                today++;
                continue;
            }

            const logHour = Math.floor(timelogs[i][j] / 100);
            const logMin  = timelogs[i][j] % 100;
            const logMinutes = logHour * 60 + logMin;

            if (logMinutes > deadlineMinutes) {
                isOnTime = false;
                break;
            }

            today++;
        }

        if (isOnTime) validCount++;
    }

    return validCount;
}
