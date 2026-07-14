class Solution {
    public int calculateTime(String timeStr) {
        String[] parts = timeStr.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        return min * 60 + sec;
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int now = calculateTime(pos);
        int end = calculateTime(video_len);
        int opStart = calculateTime(op_start);
        int opEnd = calculateTime(op_end);

        if (now >= opStart && now <= opEnd) {
            now = opEnd;
        }

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("prev")) {
                if (now > 10) {
                    now -= 10;
                } else {
                    now = 0;
                }
            } else { // "next"
                if (now + 10 > end) {
                    now = end;
                } else {
                    now += 10;
                }
            }

            if (now >= opStart && now <= opEnd) {
                now = opEnd;
            }
        }

        int answerMin = now / 60;
        int answerSec = now % 60;
        return String.format("%02d:%02d", answerMin, answerSec);
    }
}