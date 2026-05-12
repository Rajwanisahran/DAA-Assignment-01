import java.util.ArrayList;

public class GraphData {

    public static void main(String[] args) {
        int totalNodes = 4;
        int[][] graphBox = new int[totalNodes][totalNodes];
        for (int a = 0; a < totalNodes; a++) {
            for (int b = 0; b < totalNodes; b++) {
                if (a != b) {
                    graphBox[a][b] = 1;
                }
            }
        }
        System.out.println("Adjacency Matrix:");
        for (int a = 0; a < totalNodes; a++) {
            for (int b = 0; b < totalNodes; b++) {
                System.out.print(graphBox[a][b] + " ");
            }
            System.out.println();
        }
        ArrayList<ArrayList<Integer>> connectList = new ArrayList<>();
        for (int a = 0; a < totalNodes; a++) {
            connectList.add(new ArrayList<>());
        }
        for (int a = 0; a < totalNodes; a++) {
            for (int b = 0; b < totalNodes; b++) {
                if (a != b) {
                    connectList.get(a).add(b);
                }
            }
        }
        System.out.println("Adjacency List:");
        for (int a = 0; a < totalNodes; a++) {
            System.out.print(a + " -> ");
            for (int value : connectList.get(a)) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}