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
    public BallRow(int nBalls) {
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
        if (key == KeyEvent.VK_D) {
            //balls = sort(balls);
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

    /*public Ball[] sort(Ball[] balls){
        // Unterschied zw. größter und kleinster Zahl finden
            Ball smallest = null;
            Ball biggest = null;
            smallest = balls[0];
            biggest = balls[0];
            for (Ball b : balls){
                if (b != null && b.getValue() < smallest.getValue()){
                    smallest = b;
                } else if (b != null && b.getValue() > biggest.getValue()){
                    biggest = b;
                }
            }
            System.out.println("Smallest: " + smallest.getValue());
            System.out.println("Biggest: " + biggest.getValue());

        // Wdh: Array durchgehen bis eine Zahl kommt, die größer als die Hälfte des Unterschiedes ist. Cutten.
            int half = (biggest.getValue() - smallest.getValue()) / 2;
            //Ball cutBeforeThisOne = null;
            boolean lessThanHalf = true;
            int cuts = 0;
            for (Ball b : balls){
                if (b != null){
                    if (b.getValue() < half) {
                        lessThanHalf = true;
                    } else {
                        cuts++;
                        lessThanHalf = false;
                    }
                }

                 && b.getValue() > half){
                    //cutBeforeThisOne = b;

                }
            }

        // Auf diese Weise viele Arrayschnipsel schaffen mit Zahlen, die in einer der beiden Hälften sind.
            Ball

        // Schnipsel auf eine effiziente Weise sortieren
        // Zusammenführen

        return balls;
    }*/

    /*public Ball[] sort(Ball[] balls){
        // Find Pivot
            int randomBall = (int)(Math.random()*nBalls);
            Ball pivot = balls[randomBall];
            int pivotValue = pivot.getValue();

        // Division into 2 groups
            Ball[] group1 = new Ball[balls.length/2];
            int group1Index = 0;
            Ball[] group2 = new Ball[balls.length/2];
            int group2Index = 0;

            for (Ball b : balls){
                if (b.getValue() < pivotValue) {
                    group1[group1Index] = b;
                    group1Index++;
                } else{
                    group2[group2Index] = b;
                    group2Index++;
                }
            }

        // Division of first array into 2 groups
            Ball pivot1 = group1[(int)(Math.random()*group1.length)];
            int pivotValue1 = pivot1.getValue();

            Ball[] group11 = new Ball[group1.length/2];
            int group11Index = 0;
            Ball[] group12 = new Ball[group1.length/2];
            int group12Index = 0;

            for (Ball b : group1){
                if (b.getValue() < pivotValue1) {
                    group11[group11Index] = b;
                    group11Index++;
                } else{
                    group12[group12Index] = b;
                    group12Index++;
                }
            }

        // Division of second array into 2 groups
            Ball pivot2 = group2[(int)(Math.random()*group2.length)];
            int pivotValue2 = pivot2.getValue();

            Ball[] group21 = new Ball[group2.length/2];
            int group21Index = 0;
            Ball[] group22 = new Ball[group2.length/2];
            int group22Index = 0;

            for (Ball b : group2){
                if (b.getValue() < pivotValue2) {
                    group21[group21Index] = b;
                    group21Index++;
                } else{
                    group22[group22Index] = b;
                    group22Index++;
                }
            }

        // Sort 1.1
            for (int i = 0; i < group11.length; i++){
                for (int j = 1; j < group11.length; j++){
                    Ball first = null;
                    if (group11[i].getValue() > group11[j].getValue()){
                        first = group11[i];
                        group11[i] = group11[j];
                        group11[j] = first;
                    }
                }
            }

        // Sort 1.2
            for (int i = 0; i < group12.length; i++){
                for (int j = 1; j < group12.length; j++){
                    Ball first = null;
                    if (group12[i].getValue() > group12[j].getValue()){
                        first = group12[i];
                        group12[i] = group12[j];
                        group12[j] = first;
                    }
                }
            }

        // Sort 2.1
            for (int i = 0; i < group21.length; i++){
                for (int j = 1; j < group21.length; j++){
                    Ball first = null;
                    if (group21[i].getValue() > group21[j].getValue()){
                        first = group21[i];
                        group21[i] = group21[j];
                        group21[j] = first;
                    }
                }
            }

        // Sort 2.1
            for (int i = 0; i < group22.length; i++){
                for (int j = 1; j < group22.length; j++){
                    Ball first = null;
                    if (group22[i].getValue() > group22[j].getValue()){
                        first = group22[i];
                        group22[i] = group22[j];
                        group22[j] = first;
                    }
                }
            }

        // Combine 1.1 and 1.2 and sort
            for (int i = 0; i < group11.length; i++){
                group1[i] = group11[i];
            }
            for (int i = 0; i < group1.length; i++){
                group1[i+group1.length-1] = group12[i];
            }

            for (int i = 0; i < group1.length; i++){
                for (int j = 1; j < group1.length; j++){
                    Ball first = null;
                    if (group1[i].getValue() > group1[j].getValue()){
                        first = group1[i];
                        group1[i] = group1[j];
                        group1[j] = first;
                    }
                }
            }

        // Combine 2.1 and 2.2 and sort
            for (int i = 0; i < group21.length; i++){
                group2[i] = group21[i];
            }
            for (int i = 0; i < group2.length; i++){
                group2[i+group2.length-1] = group22[i];
            }

            for (int i = 0; i < group2.length; i++){
                for (int j = 1; j < group2.length; j++){
                    Ball first = null;
                    if (group2[i].getValue() > group2[j].getValue()){
                        first = group2[i];
                        group2[i] = group2[j];
                        group2[j] = first;
                    }
                }
            }

        // Combine 1 and 2 and sort
            for (int i = 0; i < group1.length; i++){
                balls[i] = group1[i];
            }
            for (int i = 0; i < balls.length; i++){
                balls[i+group1.length-1] = group2[i];
            }

            for (int i = 0; i < balls.length; i++){
                for (int j = 1; j < balls.length; j++){
                    Ball first = null;
                    if (balls[i].getValue() > balls[j].getValue()){
                        first = balls[i];
                        balls[i] = balls[j];
                        balls[j] = first;
                    }
                }
            }

        return balls;

        // Methode zum dividen machen mit Rückgabe eines Doppelarrays, je nach nBalls oft dividen
        // Methode zum untergeordneten Sortieren machen und z.B. group11 übergeben
    }*/

    public Ball[] sort(Ball[] balls){
        if (balls.length % 2 == 0){ // Wenn balls.length gerade

            // Abhängig von balls.lenth viele divisions machen mit divideArray()
            // Divisions sortieren mit sortSubArray()
            // Divisions zusammenführen mit combineSubArrays()

        } else {return balls;}

        return balls;
    }

    public Ball[][] divideArray(Ball[] balls){
        Ball[][] doubleArray = new Ball[2][balls.length/2];
        int index = 0;
        for (int i = 0; i < balls.length/2; i++){
            doubleArray[0][i] = balls[index];
            index++;
        }
        for (int i = 0; i < balls.length/2; i++){
            doubleArray[1][i] = balls[index];
            index++;
        }
        return doubleArray;
    }

    public Ball[] sortSubArray(Ball[] balls){
        // Bekommt einen Unterarray
        for (int i = 0; i < balls.length-1; i++){
            for (int j = i+1; j < balls.length; j++){
                if (balls[i].getValue() > balls[j].getValue()){
                    Ball first = balls[i];
                    balls[i] = balls[j];
                    balls[j] = first;
                }
            }
        }
        return balls;
    }

    public Ball[] combineSubArrays(Ball[][] balls){
        Ball[] newBalls = null;



        return newBalls;
    }

}

//TODO 1 public void sort
//TODO 2 Durchschnitt der Vergleichsanzahl ermitteln
