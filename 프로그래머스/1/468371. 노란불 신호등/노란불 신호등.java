class Solution {
    private long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public int solution(int[][] signals) {
        int signalsCount = signals.length;
        int[] cycle = new int[signalsCount];

        for (int i = 0; i < signalsCount; i++) {
            cycle[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }

        long maxLimit = cycle[0];
        for (int i = 1; i < signalsCount; i++) {
            maxLimit = lcm(maxLimit, cycle[i]);
            if (maxLimit > 100000000) { 
                maxLimit = 100000000;
                break;
            }
        }

        int tick = 1;
        while (tick <= maxLimit) {
            boolean allYellow = true;

            for (int i = 0; i < signalsCount; i++) {
                int pos = (tick - 1) % cycle[i];

                if (!(pos >= signals[i][0] && pos < signals[i][0] + signals[i][1])) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return tick;
            }

            tick++;
        }

        return -1;
    }
}