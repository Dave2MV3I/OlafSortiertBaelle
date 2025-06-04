package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

/**
 * Repräsentiert ein Haus. Der Teil mit "extends" wird später erklärt und jetzt ignoriert - oder wurde schon erklärt.
 */
public class Ball extends GraphicalObject {

    // Attribute
        private int value;
        private int[] color = {255,255,255};

    // Methoden
    public Ball(double x, double y, int value ){
        this.x = x;
        this.y = y;
        this.value = value;
    }
    public Ball(double x, double y){
        this.x = x;
        this.y = y;
        value = 1 + (int)(Math.random() * 98);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(color[0],color[1],color[2],255);
        drawTool.drawFilledCircle(x,y,7);
        drawTool.setCurrentColor(Color.BLACK);
        drawTool.drawCircle(x,y,8);

        drawTool.drawText(x-6,y+5,String.valueOf(value));
    }

    public void changeColor(int r, int g, int b){
        this.color[0] = r;
        this.color[1] = g;
        this.color[2] = b;
    }

    public int[] getColor() {return color;}
    public int getValue() {return value;}

}
