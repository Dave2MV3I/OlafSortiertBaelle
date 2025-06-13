package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Ball;
import my_project.model.BallRow;

public class ProgramController {

    //Attribute

    // Referenzen

    private final ViewController viewController;


    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }


    public void startProgram() {
        BallRow ballRow = new BallRow(10);
        viewController.draw(ballRow);
        viewController.register(ballRow);
    }

    public void updateProgram(double dt){

    }
}
