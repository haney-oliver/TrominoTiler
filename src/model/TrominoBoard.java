package model;

import java.awt.*;

public class TrominoBoard {

    private Color[][] board;
    private Point empty;
    private int size;
    private int colorIndex;

    public TrominoBoard(int size, Point empty) {
        this.size = size;
        this.empty = empty;
        this.board = new Color[size][size];
        fillBoard(empty.x, empty.y, size);
        this.board[empty.x][empty.y] = Color.BLACK;
        this.colorIndex = 0;
    }

    private Color[][] fillBoard(int emptyX, int emptyY, int currentSize) {
        Color currentColor = getNextColor();

        // top left
        if(emptyX <= currentSize/2 && emptyY <= currentSize/2) {
            if (currentSize == 2) {
                board[currentSize/2-1][currentSize/2] = getNextColor();
                board[currentSize/2][currentSize/2] = getNextColor();
                board[currentSize/2][currentSize/2-1] = getNextColor();
                return board;
            } else if(currentSize < 2) {
                return board;
            }
            board[currentSize/2-1][currentSize/2] = currentColor;
            board[currentSize/2][currentSize/2] = currentColor;
            board[currentSize/2][currentSize/2-1] = currentColor;

            fillBoard(currentSize/2-1, currentSize/2-1, currentSize/4);
            fillBoard(currentSize/2-1, currentSize/2, currentSize/2);
            fillBoard(currentSize/2, currentSize/2, currentSize/2);
            fillBoard(currentSize/2, (currentSize/2-1), currentSize/2);
        // bottom left
        } else if(emptyX <= currentSize/2 - 1 && emptyY >= currentSize/2) {
            if (currentSize == 2) {
                board[currentSize/2-1][currentSize/2] = getNextColor();
                board[currentSize/2][currentSize/2] = getNextColor();
                board[currentSize/2][currentSize/2-1] = getNextColor();
                return board;
            } else if(currentSize < 2) {
                return board;
            }
            board[(currentSize/2) - 1][(currentSize/2) - 1] = currentColor;
            board[currentSize/2][currentSize/2] = currentColor;
            board[currentSize/2][(currentSize/2) - 1] = currentColor;

            fillBoard(currentSize/2-1, currentSize/2-1, currentSize);
            fillBoard(currentSize/2, currentSize/2-1, currentSize);
            fillBoard(currentSize/2-1, currentSize/2, currentSize/2);
            fillBoard(currentSize/2, currentSize/2, currentSize);
        // bottom right
        } else if(emptyX >= currentSize/2 && emptyY >= currentSize/2) {
            if (currentSize == 2) {
                board[currentSize/2-1][currentSize/2] = getNextColor();
                board[currentSize/2][currentSize/2] = getNextColor();
                board[currentSize/2][currentSize/2-1] = getNextColor();
                return board;
            } else if(currentSize < 2) {
                return board;
            }
            board[(currentSize/2)-1][currentSize/2] = currentColor;
            board[(currentSize/2)-1][currentSize/2-1] = currentColor;
            board[currentSize/2][(currentSize/2)-1] = currentColor;

            fillBoard(currentSize/2-1, currentSize/2-1, currentSize);
            fillBoard(currentSize/2, currentSize/2-1, currentSize);
            fillBoard(currentSize/2-1, currentSize/2, currentSize);
            fillBoard(currentSize/2, currentSize/2, currentSize/2);
        // top right
        } else if(emptyX == currentSize/2 && emptyY <= currentSize/2-1) {
            if (currentSize <= 2) {
                board[currentSize/2-1][currentSize/2] = getNextColor();
                board[currentSize/2][currentSize/2] = getNextColor();
                board[currentSize/2][currentSize/2-1] = getNextColor();
                return board;
            } else if(currentSize < 2) {
                return board;
            }
            board[(currentSize/2)-1][currentSize/2] = currentColor;
            board[currentSize/2][currentSize/2] = currentColor;
            board[(currentSize/2)-1][(currentSize/2)-1] = currentColor;

            fillBoard(currentSize/2-1, currentSize/2-1, currentSize);
            fillBoard(currentSize/2, currentSize/2-1, currentSize/2);
            fillBoard(currentSize/2-1, currentSize/2, currentSize);
            fillBoard(currentSize/2, currentSize/2, currentSize);
        }
        return board;
    }

    private Color getNextColor() {
        Color[] colors = {Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW};
        colorIndex+=1;
        if (colorIndex > 3) {
            colorIndex = 0;
        }
        return colors[colorIndex];
    }

    public Color[][] getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }
}
