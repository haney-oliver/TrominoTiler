package viewcontroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class View {
    private Color[][] board;
    private JOptionPane sizeOptionPane;
    private JFrame mainFrame;
    private JFrame principleFrame;
    private JButton startButton;
    private int size;
    private List<Canvas> canvasList = new ArrayList<>();

    public View(ActionListener al, int size, Color[][] board) {
        this.size = size;
        this.board = board;
        init(al);
    }

    private void init(ActionListener al) {
        // Components
        sizeOptionPane = new JOptionPane("Sizes");
        String[] options = {"2","4","8","16","32","64"};
        sizeOptionPane.setOptions(options);
        startButton = new JButton("start");
        startButton.addActionListener(al);

        // Frame
        principleFrame = new JFrame("Menu");
        principleFrame.setSize(new Dimension(300, 200));
        principleFrame.setLayout(new FlowLayout());
        principleFrame.add(startButton);
        principleFrame.add(sizeOptionPane);
        principleFrame.setVisible(true);
        principleFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void render() {
        mainFrame = new JFrame("Tromino Tiler");
        mainFrame.setSize(new Dimension(size * 50, size * 50));
        mainFrame.setLayout(new GridLayout(size, size));
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

}
