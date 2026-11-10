import java.util.*;
public class Generator {
    private static int[][] maze;
    private HashMap<int[],Boolean> razors;
    private static int numIt;
    public static void run(int rows, int cols){
        maze = new int[rows][cols];
        for(int i =0;i<maze.length;i++){
            Arrays.fill(maze, 1);
        }
        for(int j=0;j<maze.length;j+=2){
            for(int p=1;p<maze.length;p+=2){
                maze[j][p]=0;
            }
        }
        numIt = (maze.length-1)*(maze.length+3)/4;


























    }
    public static void Kruskal(){
    int r = (int)(Math.random()*maze.length);
    int c = (int)(Math.random()*maze.length);
    int dir = (int)(Math.random()*3)-1;
    if(maze[r][c]==0) Kruskal();
    int nr = r+dir;
    int nc = c+dir;











    }
    public static void configure(int n){

    }
}