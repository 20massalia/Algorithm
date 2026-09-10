import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        Map<String, Integer> parkMap = new HashMap<>();
        Map<String, Integer> timeMap = new TreeMap<>();
        
        for (String s : records) {
            String[] parts = s.split(" ");
            int time = calMinutes(parts[0]);
            String carNum = parts[1];
            String inOut = parts[2];
            
            if (inOut.equals("IN")) {
                parkMap.put(carNum, time);
            } else { // OUT
                int inTime = parkMap.remove(carNum);
                int parkedTime = time - inTime;
                timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + parkedTime);
            }
        }
        
        for (String carNum : parkMap.keySet()) {
            int inTime = parkMap.get(carNum);
            int parkedTime = 1439 - inTime;
            timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + parkedTime);
        }
        
        int[] result = new int[timeMap.size()];
        int idx = 0;
        for (String carNum : timeMap.keySet()) {
            int totalTime = timeMap.get(carNum);
            
            if (totalTime <= defaultTime) {
                result[idx] = defaultFee;
            } else {
                result[idx] = defaultFee + (int)Math.ceil((totalTime - defaultTime) / (double)unitTime) * unitFee;
            }
            idx++;
        }
        
        return result;
    }
    
    private int calMinutes(String str) {
        String[] parts = str.split(":");
        int h = Integer.parseInt(parts[0]) * 60;
        int m = Integer.parseInt(parts[1]);
        
        return h + m;
    }
}