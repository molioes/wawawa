import java.util.*;

public class Kruskal {
    private int width;
    private int height;
    private boolean[][] h;
    private boolean[][] v;
    public Kruskal(int w, int h){
        run(w,h);
    }
    public void run(int wd, int ht){
        width = wd;
        height = ht;
        h = new boolean[height][width];
        v = new boolean[height][width];
        generate();
    }
    private void generate(){
        for(int i=0; i<height; i++){
            Arrays.fill(h[i],true);
            Arrays.fill(v[i],true);
        }
        List<Edge> r = new LinkedList<>();
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(j<width-1)
                    r.add(new Edge(j,i,j+1,i,false));
                if(i<height-1)
                    r.add(new Edge(j,i,j,i+1,true));
            }
        }
        Collections.shuffle(r);
        DisjointSet set = new DisjointSet(width*height);
        int carved = 0;
        int target = width*height-1;
        for(Edge e : r){
            if(carved>=target)
                break;
            int a = e.y1*width+e.x1;
            int b = e.y2*width+e.x2;
            if(set.union(a,b)){
                if(e.isHorizontal)
                    h[e.y1][e.x1] = false;
                else v[e.y1][e.x1] = false;
                carved++;
            }
        }
    }
    public void print(){
        for (int x = 0; x < width; x++) {
            System.out.print("O 0 ");
        }
        System.out.println("O");
        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++) {
                System.out.print("   ");
                if (v[y][x] && x < width - 1) {
                    System.out.print("0");
                } else if (x < width - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("0");
            for (int x = 0; x < width; x++) {
                System.out.print("O");
                if (h[y][x] && y < height - 1) {
                    System.out.print(" 0 ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("O");
        }
    }
}
class Edge{
    int x1, y1, x2, y2;
    boolean isHorizontal;
    public Edge(int a, int b, int c, int d, boolean h) {
        x1 = a;
        y1 = b;
        x2 = c;
        y2 = d;
        isHorizontal = h;
    }
}
class DisjointSet{
    private final int[] parent;
    public DisjointSet(int size){
        parent = new int[size];
        for(int i=0; i<size; i++){
            parent[i] = i;
        }
    }
    public int find(int i){
        if(parent[i]==i)
            return i;
        return parent[i]=find(parent[i]);
    }
    public boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            return true;
        }
        return false;
    }
}