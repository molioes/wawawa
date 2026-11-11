public class RazorInfo {
    private boolean isHorizontal;
    private int[] minCoords;
    private int[] maxCoords;
    private int[] startCoords;
    public RazorInfo(int minX, int minY, int maxX, int maxY, int sX, int sY){
        if(minX==maxX)
            isHorizontal = false;
        else isHorizontal = true;
        minCoords = new int[] {minX, minY};
        maxCoords = new int[] {maxX, maxY};
        startCoords = new int[] {sX,sY};
    }
    public RazorInfo(int[] min, int[] max, int[] start){
        if(min[0]==max[0])
            isHorizontal = false;
        else isHorizontal = true;
        minCoords = min;
        maxCoords = max;
        startCoords = start;
    }
}
