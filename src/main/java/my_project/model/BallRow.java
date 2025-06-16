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
            System.out.println("Comparisons: " + search(randomValue));
        }
    }

    public int search(int value){
        for (Ball b : balls){
            if (b != null){
                b.changeColor(255, 255, 255);
            }
        }

        int comparisons = 0;
        for (Ball b : balls){
            comparisons+=3;
            if (b != null){
                if (b.getValue() == value){
                    b.changeColor(173,216,230);
                    return comparisons;
                }
            }
        }
        return comparisons;
    }

    public Ball[] sort(Ball[] balls){
        // Unterschied zw. größter und kleinster Zahl finden
        // Wdh: Array durchgehen bis eine Zahl kommt, die größer als die Hälfte des Unterschiedes ist. Cutten.
        // Auf diese Weise viele Arrayschnipsel schaffen mit Zahlen, die in einer der beiden Hälften sind.
        // Schnipsel auf eine effiziente Weise sortieren
        // Zusammenführen

        return balls;
    }

}

//TODO 1 public void sort
//TODO 2 Durchschnitt der Vergleichsanzahl ermitteln
