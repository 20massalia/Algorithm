class Solution {
    public int solution(String dartResult) {
        int calc[] = new int[3];
        int index = -1;
        
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            
            if (Character.isDigit(ch)) {
                index++;
                
                int score = ch - '0';
                
                // 10점인 경우
                if (ch == '1' && i + 1 < dartResult.length() && dartResult.charAt(i + 1) == '0') {
                    score = 10;
                    i++;
                }
                
                // 보너스 문자
                i++;
                char bonus = dartResult.charAt(i);
                
                if (bonus == 'S') {
                    calc[index] = score;
                } else if (bonus == 'D') {
                    calc[index] = score * score;
                } else if (bonus == 'T') {
                    calc[index] = score * score * score;
                }
                
            } else { // 특수기호
                if (ch == '*') {
                    calc[index] *= 2;
                    if (index > 0) {
                        calc[index - 1] *= 2;
                    }
                } else if (ch == '#') {
                    calc[index] = -calc[index];
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += calc[i];
        }
        
        return answer;
    }
}