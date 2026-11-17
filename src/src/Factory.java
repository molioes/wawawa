import java.util.*;
public class Factory {
    private static char[][] maze;
    private static HashSet<BowlData> bowls;
    public static void run(int rows, int cols) {
        Kruskal k = new Kruskal(rows,cols);
        maze = new char[rows][];
        String[] split = k.report().split("\n");
        int i = 0;
        for(String s : split){
            maze[i++] = s.toCharArray();
        }
        loop((int) Math.floor(maze.length*maze[0].length*(Math.random()*1.25)));
        configure((int) Math.ceil(maze.length*(Math.random()*0.5)));
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
        System.out.println(n);
        int panic = 0;
        bowls = new HashSet<>();
        while(n>0&&panic++<maze.length*maze[0].length/4){
            int r = (int) (Math.random()*maze.length);
            int c = (int) (Math.random()*maze[0].length);
            boolean b = ((int)(Math.random()*2))==1;
            if(maze[r][c]=='1') {
                int[][] span = findLongestSpan(r, c, b);
                if(span[0][0]!=span[1][0]||span[0][1]!=span[1][1]) {
                    BowlData razr = new BowlData(span[0], span[1], new int[]{r, c});
                    if (!isContained(razr)) {
                        bowls.add(razr);
                        n--;
                    }
                }
            }
        }
    }
    private static int[][] findLongestSpan(int r, int c, boolean horizontal){
        int[][] span = new int[2][2];
        int i;
        if(horizontal){
            i = c;
            while(i>=0&&maze[r][i]=='1')
                i--;
            span[0] = new int[] {r,i+1};
            i = c;
            while(i<maze[0].length&&maze[r][i]=='1')
                i++;
            span[1] = new int[] {r,i-1};
        } else {
            i = r;
            while(i>=0&&maze[i][c]=='1')
                i--;
            span[0] = new int[] {i+1,c};
            i = r;
            while(i<maze.length&&maze[i][c]=='1')
                i++;
            span[1] = new int[] {i-1,c};
        }
        return span;
    }
    private static boolean isContained(BowlData bowl){
        for(BowlData b : bowls)
            if(b.intersects(bowl))
                return true;
        return false;
    }
    public static char[][] getMaze(){
        return maze;
    }
    public static HashSet<BowlData> getBowls(){
        return bowls;
    }
}