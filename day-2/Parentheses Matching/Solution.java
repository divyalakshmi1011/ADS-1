
class LinkedListStack {
    Node first = null;
    class Node {
        char data;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void push(char ch) {
        Node first = new Node();
        Node oldFirst = null;
        first.data = ch;
        first.next = oldFirst;
    }
    public char pop() {
        char store = first.data;
        first = first.next;
        return store;
    }
}
public class Solution{ 
	public static String isMatching(String s){
		LinkedListStack stack  = new LinkedListStack();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return "NO";
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return "NO";
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return "NO";
                }
            } 
        }
        if(stack.isEmpty()) {
			return "YES";
		} return "NO";
	}
}

