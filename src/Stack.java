import common.CommonUtil;

public class Stack {

    private int elements;
    private int[] arr;

    public Stack() {
        arr = new int[2];
        elements = 0;
    }

    public void push(int value) {
        if (elements == arr.length) {
            resizeArr(2 * arr.length);
        }
        arr[elements++] = value;
        System.out.println("Value added in the stack: " + value);
    }

    public int pop() {
        if (elements == 0) {
            throw new RuntimeException("Stack underflow");
        }
        int value = arr[--elements];
        arr[elements] = 0;
        if (elements > 0 && elements == arr.length / 4) {
            resizeArr(arr.length / 2);
        }
        return value;
    }

    public int peek() {
        if (elements == 0) {
            throw new RuntimeException("Stack underflow");
        }
        return arr[elements - 1];
    }

    public void stackElements() {
        CommonUtil.printArray(arr);
    }

    private void resizeArr(int size) {
        int[] temp = new int[size];

        for (int i = 0; i < elements; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(4);
        stack.push(7);
        stack.push(9);
        stack.push(2);
        stack.push(1);

        System.out.println("Current Stack");
        stack.stackElements();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Pop element: " + stack.pop());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(1);

        stack.stackElements();
    }

}
