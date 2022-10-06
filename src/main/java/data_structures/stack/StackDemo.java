package data_structures.stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(111);
        stack.push(222);
        stack.push(333);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.pop();
        System.out.println(stack.size());
        System.out.println(stack.peek());
    }
}
