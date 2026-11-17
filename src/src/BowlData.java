public class BowlData {
    private boolean isHorizontal;
    private int[] minCoords;
    private int[] maxCoords;
    private int[] startCoords;
    public BowlData(int minX, int minY, int maxX, int maxY, int sX, int sY){
        if(minX==maxX)
            isHorizontal = false;
        else isHorizontal = true;
        minCoords = new int[] {minX, minY};
        maxCoords = new int[] {maxX, maxY};
        startCoords = new int[] {sX,sY};
    }
    public BowlData(int[] min, int[] max, int[] start){
        if(min[0]==max[0])
            isHorizontal = true;
        else isHorizontal = false;
        minCoords = min;
        maxCoords = max;
        startCoords = start;
    }
    public boolean intersects(BowlData o){
        if(isHorizontal&&o.isHorizontal){
            if(minCoords[0]!=o.minCoords[0])
                return false;
            return !(minCoords[1]<=o.maxCoords[1]&&maxCoords[1]<=o.minCoords[1]);
        }
        if(!isHorizontal&&!o.isHorizontal) {
            if (minCoords[1] != o.minCoords[1])
                return false;
            return !(minCoords[0] <= o.maxCoords[0] && maxCoords[0] <= o.minCoords[0]);
        }
        return false;
    }
    public int length(){
        return Math.max(Math.abs(minCoords[0]-maxCoords[0]),Math.abs(minCoords[1]-maxCoords[1]));
    }
    public String toString(){
        return minCoords[0]+","+minCoords[1]+" - "+maxCoords[0]+","+maxCoords[1]+" ("+(isHorizontal?"horizontal":"vertical")+")";
    }
}
