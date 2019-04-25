package viewcontroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class View {
    private Color[][] board;
    private JComboBox<String> sizeOptionPane;
    private JFrame mainFrame;
    private JFrame principleFrame;
    private JButton startButton;
    private int size;
    private List<Canvas> canvasList = new ArrayList<>();

    public View(ActionListener al) {
        init(al);
    }

    private void init(ActionListener al) {
        // Components
        sizeOptionPane = new JComboBox<>();
        String[] options = {"2","4","8","16","32","64"};
        for (int i = 0; i < options.length; i++) {
            sizeOptionPane.addItem(options[i]);
        }
        startButton = new JButton("start");
        startButton.addActionListener(al);

        // Frame
        principleFrame = new JFrame("Menu");
        principleFrame.setSize(new Dimension(200, 100));
        principleFrame.setLayout(new FlowLayout());
        principleFrame.add(startButton);
        principleFrame.add(sizeOptionPane);
        principleFrame.setVisible(true);
        principleFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void render(int size, Color[][] board) {
        this.board = board;
        this.size = size;
        mainFrame = new JFrame("Tromino Tiler");
        mainFrame.setSize(new Dimension(size * 25, size * 25));
        mainFrame.setLayout(new GridLayout(size, size));
        mainFrame.setVisible(true);

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                Color color = board[i][j];
                Canvas canvas = new Canvas();
                canvas.setBackground(color);
                canvasList.add(canvas);
                mainFrame.add(canvas);
            }
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                Color color = board[i][j];
                if (color == null) {
                    System.out.print("null  ");
                } else {
                    System.out.print(convertColorToString(color));
                }
            }
            System.out.println();
        }
    }

    private String convertColorToString(Color color) {
        if(color.equals(Color.BLACK)) {
            return "black ";
        } else if(color.equals(Color.BLUE)) {
            return "blue  ";
        } else if(color.equals(Color.GREEN)) {
            return "green ";
        } else if(color.equals(Color.RED)) {
            return "red   ";
        } else {
            return "yellow";
        }
    }

    // Getters
    public JFrame getMainFrame() {
        return mainFrame;
    }

    public JFrame getPrincipleFrame() {
        return principleFrame;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JComboBox<String> getSizeOptionPane() {
        return sizeOptionPane;
    }

}
