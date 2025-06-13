package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.Config;

import java.awt.event.KeyEvent;

public class BallRow extends InteractiveGraphicalObject {

    // Attribute
        private int nBalls;
        private Ball[] balls;
        private int tries;

    // Methoden
    public BallRow(int nBalls ) {
        this.nBalls = nBalls;
        balls = new Ball[nBalls];
        double randomY = 100 + Math.random() * (Config.WINDOW_HEIGHT-200);
        for (int i = 0; i < balls.length; i++){
            balls[i] = new Ball(50 + 25*i, randomY);
        }
    }

    @Override
    public void draw(DrawTool drawTool){
        for (int i = 0; i < balls.length; i++) {
            if (balls[i] != null) {
                balls[i].draw(drawTool);
            }
        }
    }

    @Override
    public void keyPressed(int key){
        if (key == KeyEvent.VK_S) {
            int randomValue = (int)(1+Math.random()*98);
            System.out.println(randomValue);
            if(search(randomValue)){
                System.out.println("Tries till found " + randomValue + " : " + tries);
            }
        }
    }

    public boolean search(int value){
        boolean found = false;
        for (Ball b : balls){
            if (b != null){
                if (!found && b.getValue() == value){
                    found = true;
                    b.changeColor(173,216,230);
                } else b.changeColor(255, 255, 255);
            }
        }

        tries++;
        return found;
    }

}
