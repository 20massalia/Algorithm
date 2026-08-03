import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        int[] period = new int[26];
        int todayDays = getDateInDays(today);
        
        for (int i = 0; i < terms.length; i++) {
            String[] parts = terms[i].split(" ");
            int index = parts[0].charAt(0) - 'A'; 
            period[index] = Integer.parseInt(parts[1]);
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            int privacyDays = getDateInDays(parts[0]);
            int index = parts[1].charAt(0) - 'A';
            
            if (privacyDays + (period[index] * 28) <= todayDays) {
                answerList.add(i + 1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
                
    private int getDateInDays(String date) {
        String[] d = date.split("\\."); 
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);

        return (year * 12 * 28) + (month * 28) + day; 
    }
}