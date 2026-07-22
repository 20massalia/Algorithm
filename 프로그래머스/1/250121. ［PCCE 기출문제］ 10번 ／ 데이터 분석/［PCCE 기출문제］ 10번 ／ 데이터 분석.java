import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extCol = getColIndex(ext);
        int index = 0;
        int[][] temp = new int[data.length][];
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][extCol] < val_ext) { 
                temp[index++] = data[i];
            }
        }
        
        int[][] answer = Arrays.copyOf(temp, index);
        
        int sortCol = getColIndex(sort_by);
        Arrays.sort(answer, (a, b) -> a[sortCol] - b[sortCol]);
        
        return answer;
    }
    
    private int getColIndex(String key) {
        switch(key) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
        }
        
        return -1;
    }
}