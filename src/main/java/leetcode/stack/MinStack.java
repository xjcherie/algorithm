package leetcode.stack;

import java.util.Stack;

/**
 * Created by Cherie on 2020/04/10
 * https://leetcode.com/problems/min-stack/
 * todo
 **/
public class MinStack {

    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.empty()) {
            stack.push(new int[]{x, x});
            return;
        }
        int currentMin = stack.peek()[1];
        stack.push(new int[]{x, Math.min(currentMin, x)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
