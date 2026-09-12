import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean exploded = false;
            
            // Collision only happens when current is moving left (-) and top of stack is moving right (+)
            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                int top = stack.peek();
                
                if (Math.abs(ast) > top) {
                    // Current asteroid is bigger, top one explodes. Keep checking.
                    stack.pop();
                } else if (Math.abs(ast) == top) {
                    // Both are same size, both explode.
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    // Top one is bigger, current one explodes.
                    exploded = true;
                    break;
                }
            }
            
            // If the current asteroid didn't explode, push it to the stack
            if (!exploded) {
                stack.push(ast);
            }
        }
        
        // Convert the stack back to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}