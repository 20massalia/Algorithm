import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        makeMultiSet(str1, map1);
        makeMultiSet(str2, map2);
        
        int intersection = 0;
        int union = 0;
        
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) intersection += Math.min(map1.get(key), map2.get(key));
        }
        
        int total1 = 0;
        for (int count : map1.values()) {
            total1 += count;
        }
        
        int total2 = 0;
        for (int count : map2.values()) {
            total2 += count;
        }
        
        union = total1 + total2 - intersection;
        
        if (union == 0) return 65536;
        
        double similarity = (double) intersection / union;
        return (int) (similarity * 65536);
    }
    
    private void makeMultiSet(String str, Map<String, Integer> map) {
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                String sub = "" + c1 + c2;
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
    }
}