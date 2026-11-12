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
        loop((int) Math.floor(maze.length*maze[0].length*(Math.random()*1.25)));
    }
    private static void loop(int n){
        int panic = 0;
        while(n>0&&panic++<maze.length*maze[0].length/2){
            int r = (int) (Math.random()*maze.length);
            int c = (int) (Math.random()*maze[0].length);
            if(adj(r,c,true)==1){
                maze[r][c] = '1';
                n--;
            }
        }
    }
    private static int adj(int r, int c, boolean o){
        if(r<0||r>=maze.length||c<0||c>=maze[r].length)
            return -1;
        if(!o)
            return maze[r][c]=='1'?1:0;
        int U = adj(r-1,c,false);
        int D = adj(r+1,c,false);
        int L = adj(r,c-1,false);
        int R = adj(r,c+1,false);
        return (U==1&&D==1&&(L!=1||R!=1))||(L==1&&R==1&&(U!=1||D!=1))?1:0;
    }
    public static void configure(int n){

    }
    public static char[][] getMaze(){
        return maze;
    }
}