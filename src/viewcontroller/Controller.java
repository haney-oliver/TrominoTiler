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
        this.view = new View(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == view.getStartButton()) {
                    trominoBoard = new TrominoBoard(Integer.parseInt(view.getSizeOptionPane().getSelectedItem().toString()), new Point(5, 5));
                    view.render(trominoBoard.getSize(), trominoBoard.getBoard());
                }
            }
        });
    }
}
