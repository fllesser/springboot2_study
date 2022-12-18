package _023_isvalid;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (!map.containsKey(temp)) {
                stack.push(temp);
            } else {
                if (stack.isEmpty()) return false;
                if (map.get(temp) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
