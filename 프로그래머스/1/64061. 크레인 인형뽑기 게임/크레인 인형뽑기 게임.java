import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        
        for (int i = 0; i < moves.length; i++) {
            int line = moves[i] - 1; 
            
            for (int j = 0; j < board.length; j++) {
                if (board[j][line] != 0) { 
                    int doll = board[j][line];
                    board[j][line] = 0;
                    
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(doll);
                    }
                    
                    break;
                }
            }
        }
        
        return answer;
    }
}