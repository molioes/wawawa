import java.util.*;
public class Factory {
    private static char[][] maze;
    private HashMap<int[],Boolean> razors;
    private static int numIt;
    public static void run(int rows, int cols) {
        Kruskal k = new Kruskal(rows,cols);
        maze = new char[rows][];
        String[] split = k.report().split("\n");
        int i = 0;
        for(String s : split){
            maze[i++] = s.toCharArray();
        }
    }
    public static void configure(int n){

    }
}