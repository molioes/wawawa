import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
class mazeOnScreen extends Canvas{
    private char[][] maze;
    public mazeOnScreen(char[][] m){
        maze = m;
    }

    @Override
    public void paint(Graphics window) {
        window.setColor(Color.BLACK);
        window.drawString("maze",200,200);
        for(int i =0;i<maze.length;i++){
            for(int j = 0;j<maze.length;j++){
                if(maze[i][j]=='0'){
                    window.fillRect(i*50,j*50,50,50);
                }
            }
        }
    }
}