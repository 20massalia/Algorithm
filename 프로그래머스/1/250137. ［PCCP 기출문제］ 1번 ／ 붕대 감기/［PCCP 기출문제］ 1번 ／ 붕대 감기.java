class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int seq = 0;
        int max = health;
        int attackIdx = 0;
        
        for (int t = 0; t <= attacks[attacks.length - 1][0]; t++) {
            if (t == attacks[attackIdx][0]) { // 현재 공격
                health -= attacks[attackIdx][1];
                seq = 0;
                attackIdx++;
                
                if (health <= 0) return -1;
            } else {
                seq++;
                health += bandage[1];
                
                if (seq == bandage[0]) {
                    health += bandage[2];
                    seq = 0;
                }
                
                if (health > max) health = max;
            }
        }
        
        return health;
    }
}