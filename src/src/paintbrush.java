import java.awt.*;
import java.util.Arrays;

class paintbrush extends Brick{
    private int x, y, w, h;
    private Image I;
    private int[][] painted;


    public paintbrush(int xx, int yy, int ww, int hh, int size){
        x = xx;
        y = yy;
        w = ww;
        h = hh;
        I=Toolkit.getDefaultToolkit().getImage("uppies.jpg");
        painted = new int[size][size];
        for(int i =0;i<painted.length;i++){
            Arrays.fill(painted[i],0);
        }
    }
    public int getX( ){ return x; }
    public void setX( int ex ){ x = ex; }
    public int getY( ){ return y; }
    public void setY( int wy ){ y = wy; }
    public int getW(){ return w; }
    public int getH(){ return h; }
    public void getPaint(){
        painted[getX()/10][getY()/10]=1;
    }
    public void moveLeft(mazeOnScreen m){
        I=Toolkit.getDefaultToolkit().getImage("lefties.png");
        if(getX()>15&&onPath(m))
            setX(getX()-50);
        if(!onPath(m)) setX(getX()+50);
        getPaint();
    }
    public void moveRight(mazeOnScreen m){
        I=Toolkit.getDefaultToolkit().getImage("rights.png");
        if(getX()<420)
            setX(getX()+50);
        if(!onPath(m)) setX(getX()-50);
        getPaint();
    }
    public void moveUp(mazeOnScreen m){
        I=Toolkit.getDefaultToolkit().getImage("uppies.jpg");
        if(getY()>15)
            setY(getY()-50);
        if(!onPath(m))setY(getY()+50);
        getPaint();
    }
    public void moveDown(mazeOnScreen m){
        I=Toolkit.getDefaultToolkit().getImage("downs.png");
        if(getY()<420)
            setY(getY()+50);
        if(!onPath(m))setY(getY()-50);
        getPaint();
    }
    public boolean onPath(mazeOnScreen m){
        boolean yes=true;
        Rectangle p = new Rectangle(getX(),getY(),getW(),getH());
        for(int i =0;i<m.getList().size();i++){
            if(m.getList().get(i).intersects(p)){
                return false;
            }
        }
        return true;

    }
    public void paint( Graphics window )
    {

        //Draw the Paddle with graphics methods
        //or use an Image
        window.setColor(Color.PINK);
        for(int i =0;i<painted.length;i++){
            for(int j = 0;j<painted.length;j++){
                if(painted[i][j]==1){
                    window.fillRect(i*10,j*10,50,50);
                }
            }
        }

        //PICK ONE -  YOU CANNOT DO BOTH!!!!


		/*
		window.setColor(Color.RED);
		window.fillRect(getX(), getY(), getW(), getH());
		window.setColor(Color.BLACK);
		window.drawRect(getX(), getY(), getW(), getH());
		*/

        //Find an Image for your Paddle.

		Graphics2D g2 = (Graphics2D) window; //use .gif or .png, you can choose the image
    	g2.drawImage(I, getX(), getY(), getW(), getH(), this);

    }
    //wuahawugwa
}