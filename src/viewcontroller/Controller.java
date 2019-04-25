package viewcontroller;

import model.TrominoBoard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;
    private TrominoBoard trominoBoard;
    // Instantiate view by passing action listener to listen for button presses
    public Controller() {
        this.trominoBoard = new TrominoBoard(16, new Point(4, 6));
        this.view = new View(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == view.getStartButton()) {
                    view.render();
                }
            }
        }, trominoBoard.getSize(), trominoBoard.getBoard());
    }
}
