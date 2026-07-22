class Solution {
    int count = 0;
    String[] available = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {    
        for (int i = 0; i < babbling.length; i++) {
            isIncluded(babbling[i], -1);
        }
        
        return count;
    }
    
    public void isIncluded(String str, int prevIndex) {
        if (str.isEmpty()) {
            count++;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (str.startsWith(available[i]) && i != prevIndex) {
                isIncluded(str.substring(available[i].length()), i);
            }
        }
    }
}