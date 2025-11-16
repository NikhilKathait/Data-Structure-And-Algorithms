import java.util.*;

public class minStack {
    class Solution {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int x) {
            stack.push(x);

            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            } else {
                // push the current minimum again to maintain size sync
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) return -1;
            return stack.peek();
        }

        public int getMin() {
            if (minStack.isEmpty()) return -1;
            return minStack.peek();
        }
    }
}
