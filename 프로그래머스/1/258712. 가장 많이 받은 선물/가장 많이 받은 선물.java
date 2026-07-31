import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> nameIndex = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            nameIndex.put(friends[i], i);
        }
        
        int n = friends.length;
        int[][] giftRecords = new int[n][n];
        
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giverIndex = nameIndex.get(parts[0]);
            int receiverIndex = nameIndex.get(parts[1]);   
            giftRecords[giverIndex][receiverIndex]++;
        }
        
        int[] giftPoint = new int[n];
        for (int i = 0; i < n; i++) {
            int giveCount = 0;
            int receiveCount = 0;
            
            for (int j = 0; j < n; j++) {
                giveCount += giftRecords[i][j];
                receiveCount += giftRecords[j][i];
            }
            
            giftPoint[i] = giveCount - receiveCount;
        }
        
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftRecords[i][j] > giftRecords[j][i]) {
                    score[i]++;
                } else if (giftRecords[i][j] < giftRecords[j][i]) {
                    score[j]++;
                } 
                else {
                    if (giftPoint[i] > giftPoint[j]) {
                        score[i]++;
                    } else if (giftPoint[i] < giftPoint[j]) {
                        score[j]++;
                    }
                }
            }
        }
            
        int answer = 0;
        for (int count : score) {
            answer = Math.max(answer, count);
        }
            
        return answer;
    }
}