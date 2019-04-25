package viewcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;

    // Instantiate view by passing action listener to listen for button presses
    public Controller() {
        this.view = new View(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
