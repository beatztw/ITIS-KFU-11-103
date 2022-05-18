package leetCodeHW;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {
    public boolean isValid(String s) {
        Deque<Character> arr = new ArrayDeque<Character>();
        if(s.length() == 0 || s.length() == 1) {
            return false;
        }
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if(arr.isEmpty()) {
                    return false;
                }
                char c = arr.pop();
                if(s.charAt(i) == ')' && (c == '[' || c == '{')) {
                    return false;
                } else if(s.charAt(i) == '}' && (c == '[' || c == '(')) {
                    return false;
                } else if(s.charAt(i) == ']' && (c == '(' || c == '{')) {
                    return false;
                }

            } else {
                arr.push(s.charAt(i));
            }
        }

        return arr.size() == 0;
    }
}
