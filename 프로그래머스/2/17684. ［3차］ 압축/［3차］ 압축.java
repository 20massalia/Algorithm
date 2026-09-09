import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        
        for (int i = 0; i < 26; i++) {
            String key = String.valueOf((char)(i + 65));
            dict.put(key, i + 1);
        }
        
        int i = 0;
        while (i < msg.length()) {
            for (int j = i + 1; j <= msg.length(); j++) {
                if (dict.containsKey(msg.substring(i, j))) {
                    if (j == msg.length()) {
                        answer.add(dict.get(msg.substring(i, j)));
                        i = j;
                        break;
                    }
                    continue;
                } else {
                    answer.add(dict.get(msg.substring(i, j - 1)));
                    dict.put(msg.substring(i, j), dict.size() + 1);
                    i = j - 1;
                    break;
                }
            }
        }

        int[] result = new int[answer.size()];
        for (int idx = 0; idx < answer.size(); idx++) {
            result[idx] = answer.get(idx);
        }
        
        return result;
    }
}