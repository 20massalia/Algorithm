import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        Set<String> normalWords = new HashSet<>();
        Set<String> spoilerWords = new HashSet<>();
        
        int len = message.length();
        int i = 0;
        
        while (i < len) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }
            
            int start = i;
            while (i < len && message.charAt(i) != ' ') {
                i++;
            }
            int end = i - 1;
            String word = message.substring(start, i);
            
            boolean isSpoiler = false;
            for (int[] range : spoiler_ranges) {
                if (range[0] <= end && range[1] >= start) {
                    isSpoiler = true;
                    break;
                }
            }
            
            if (isSpoiler) {
                spoilerWords.add(word);
            } else {
                normalWords.add(word);
            }
        }
        
        spoilerWords.removeAll(normalWords);
        
        return spoilerWords.size();
    }
} 