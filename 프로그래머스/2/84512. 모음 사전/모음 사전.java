import java.util.*;

class Solution {
    static List<String> list;
    static String[] vowels = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        list = new ArrayList<>();
        dfs("", 0);
        
        return list.indexOf(word);
    }
    
    static void dfs(String str, int len) {
        list.add(str);
        
        if (len == 5) return;
        
        for (int i = 0; i < 5; i++) {
            dfs(str + vowels[i], len + 1);
        }
    }
}