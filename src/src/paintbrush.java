import java.awt.*;

class paintbrush extends Brick{
    private int x, y, w, h;
    private Image I;



    public paintbrush(int xx, int yy, int ww, int hh){
        x = xx;
        y = yy;
        w = ww;
        h = hh;
        I=Toolkit.getDefaultToolkit().getImage("images.jpg");
    }
    public int getX( ){ return x; }
    public void setX( int ex ){ x = ex; }
    public int getY( ){ return y; }
    public void setY( int wy ){ y = wy; }
    public int getW(){ return w; }
    public int getH(){ return h; }
    public void moveLeft(){
        I=Toolkit.getDefaultToolkit().getImage("left.png");
        setX(getX()-10);
    }
    public void moveRight(){
        I=Toolkit.getDefaultToolkit().getImage("right.png");
        setX(getX()+10);
    }
    public void moveUp(){
        I=Toolkit.getDefaultToolkit().getImage("images.jpg");
        setY(getY()-10);
    }
    public void moveDown(){
        I=Toolkit.getDefaultToolkit().getImage("down.png");
        setY(getY()+10);
    }
    public void paint( Graphics window )
    {

        //Draw the Paddle with graphics methods
        //or use an Image


        //PICK ONE -  YOU CANNOT DO BOTH!!!!


		/*
		window.setColor(Color.RED);
		window.fillRect(getX(), getY(), getW(), getH());
		window.setColor(Color.BLACK);
		window.drawRect(getX(), getY(), getW(), getH());
		*/

        //Find an Image for your Paddle.

		Graphics2D g2 = (Graphics2D) window;
    	//use .gif or .png, you can choose the image
    	g2.drawImage(I, getX(), getY(), getW(), getH(), this);

    }
    //wuahawugwa
}