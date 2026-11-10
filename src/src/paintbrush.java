import java.awt.*;

class paintbrush extends Brick{
    private int x, y, w, h;

    public paintbrush(){
        x = 2;
        y = 2;
        w = 2;
        h = 2;
    }

    public paintbrush(int xx, int yy, int ww, int hh){
        x = xx;
        y = yy;
        w = ww;
        h = hh;
    }
    public void paint( Graphics window )
    {
        window.drawString("Paddle Class ", 50, 150 );

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
    	Image img1 = Toolkit.getDefaultToolkit().getImage("images.jpg"); //use .gif or .png, you can choose the image
    	g2.drawImage(img1, getX(), getY(), getW(), getH(), this);

    }
    //wuahawugwa
}