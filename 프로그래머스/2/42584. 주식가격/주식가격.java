import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int leftIdx = stack.pop();
            answer[leftIdx] = len - 1 - leftIdx;
        }

        return answer;
    }
}