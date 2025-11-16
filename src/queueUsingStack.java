import java.util.*;

public class queueUsingStack {
    public static class UserQueue {

        static Stack<Integer> inStack;
        static Stack<Integer> outStack;

        /** Initialize your data structure here. */
        UserQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /** Push element X to the back of queue. */
        static void push(int X) {
            inStack.push(X);
        }

        /** Removes the element from in front of queue and returns that element. */
        static int pop() {
            if(outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        /** Get the front element of the queue. */
        static int peek() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }

            return outStack.peek();
        }

        /** Returns whether the queue is empty. */
        static boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

/**
 * Your UserQueue object will be instantiated and called as such:
 * UserQueue obj = new UserQueue();
 * obj.push(X);
 * int param2 = obj.pop();
 * int param3 = obj.peek();
 * boolean param4 = obj.empty();
 */
}
