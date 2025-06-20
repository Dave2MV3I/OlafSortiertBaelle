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

    /** ---------------------------------------------------------------------- <br>
     * IDEE: <br> <br>
     * 2D Array mit so vielen Subarray, dass jeder Subarray.length <= 2 || <br>
     * Wenn ein subarray.length > 2 ihn teilen || <br>
     * Für jeden Aufruf von divide(...) wird ein neuer Array mit mehr 1D-Plätzen und weniger 2D-Plätzen pro 1D-Platz erstellt || <br>
     * Aufteilung nach < oder > double average, also klein -> groß von links nach rechts || <br>
     * new Array [Summe aller subarray.length] und Zusammenführen der Subarrays || <br>
     ---------------------------------------------------------------------- */

    public Ball[] sort(Ball[] unsortedBalls){
        if (unsortedBalls.length > 1){
            // Davon ausgehend, dass keine Stelle im Array null ist

            // 1. Ursprüngliches Array in ein 2D-Array mit einem Subarray umwandeln
                Ball[][] newArray = new Ball[1][unsortedBalls.length];
                for (int i = 0; i < unsortedBalls.length; i++){
                    newArray[0][i] = unsortedBalls[i];
                }

            // Solange auch nur einer der Subarrays mehr als 2 Stellen hat, wird er geteilt
                int divisionsNeeded = getDivisionsNeeded(newArray);
                while (divisionsNeeded > 0){
                    Ball[][] tempNewArray = new Ball[newArray.length+divisionsNeeded][];
                    int index = 0;
                    for (Ball[] subarray : newArray){
                        if (subarray.length <= 2){
                            tempNewArray[index++] = subarray;
                        } else {
                            Ball[][] dividedArray = divideArray(subarray);
                            tempNewArray[index++] = dividedArray[0];
                            tempNewArray[index++] = dividedArray[1];
                        }
                    }
                    newArray = tempNewArray;
                }

            // Sobald die Länge aller Subarrays <=2 ist zusammenführen


        }

        return unsortedBalls; // Wenn nur 1 Ball im array
    }

    public int getDivisionsNeeded(Ball[][] array){
        int divisions = 0;
        for (Ball[] subarray : array){
            if (subarray.length > 2) divisions++;
        }
        return divisions;
    }

    public double getAverage(Ball[] array){
        int sum = 0;
        for (Ball b : array){
            sum += b.getValue();
        }
        return sum/array.length;
    }

    public Ball[][] divideArray(Ball[] array){
        Ball[][] array2D = new Ball[2][];

        double average = getAverage(array);

        int lessThanAverage = 0;
        int moreThanAverage = 0;

        for (Ball b : array){
            if (b.getValue() < average){
                lessThanAverage++;
            } else if (b.getValue() > average){
                moreThanAverage++;
            }
        }

        array2D[0] = new Ball[lessThanAverage];
        int index1 = 0;
        array2D[1] = new Ball[moreThanAverage];
        int index2 = 0;

        for (Ball b : array){
            if (b.getValue() < average){
                array2D[0][index1] = b;
                index1++;
            } else if (b.getValue() > average){
                array2D[1][index2] = b;
                index2++;
            }
        }

        return array2D;
    }

    public Ball[][] sortAndMergeSubarrays(Ball[][] array){ // Only called in the end
        return null;
    }

    public Ball[] mergeSubarrays(Ball[][] array){ // Only called in the end by sortAndMergeSubarrays
        return null;
    }



}

//TODO 1 public void sort
//TODO 2 Durchschnitt der Vergleichsanzahl ermitteln
