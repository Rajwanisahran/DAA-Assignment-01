import java.util.*;

public class GraphOrder {

    private int size = 14;
    private LinkedList<Integer>[] data;

    public GraphOrder() {
        data = new LinkedList[size];
        for (int x = 0; x < size; x++) {
            data[x] = new LinkedList<>();
        }
    }
    private int getValue(char ch) {
        String letters = "mnopqrstuvwxyz";
        return letters.indexOf(ch);
    }
    private char getLetter(int num) {
        String letters = "mnopqrstuvwxyz";
        return letters.charAt(num);
    }
    public void connect(char first, char second) {
        data[getValue(first)].add(getValue(second));
    }
    private void check(int current, boolean[] done, Stack<Integer> result) {
        done[current] = true;
        for (int next : data[current]) {
            if (!done[next]) {
                check(next, done, result);
            }
        }
        result.push(current);
    }
    public void display() {
        Stack<Integer> result = new Stack<>();
        boolean[] done = new boolean[size];
        for (int x = 0; x < size; x++) {
            if (!done[x]) {
                check(x, done, result);
            }
        }
        System.out.println("Topological Order:");
        while (!result.isEmpty()) {
            System.out.print(getLetter(result.pop()) + " ");
        }
    }
    public static void main(String[] args) {
        GraphOrder obj = new GraphOrder();
        obj.connect('m', 'q');
        obj.connect('m', 'r');
        obj.connect('m', 'x');

        obj.connect('n', 'o');
        obj.connect('n', 'q');
        obj.connect('n', 'u');

        obj.connect('o', 'r');
        obj.connect('o', 's');
        obj.connect('o', 'v');

        obj.connect('p', 'o');
        obj.connect('p', 's');
        obj.connect('p', 'z');

        obj.connect('q', 't');

        obj.connect('r', 'u');
        obj.connect('r', 'y');

        obj.connect('s', 'r');

        obj.connect('u', 't');

        obj.connect('v', 'w');
        obj.connect('v', 'x');

        obj.connect('w', 'z');
        obj.display();
    }
}