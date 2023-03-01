package src.src.games.boards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static src.src.games.boards.Player.One;
import static src.src.games.boards.Player.Two;


public class Board extends JPanel{
    private final Cell[][] cells;
    private int row;
    private int column;
    private Player current_player;

    public void paintComponent ( Graphics gr) {
        super.paintComponent(gr);
        gr.setColor(Color.BLACK);
        gr.drawString( "TIC-TAE-TOE", 300, 300 );

    }


    public Board(int rows, int columns,  ActionListener ah) {
        cells = new Cell[rows][columns];
        row = rows;
        column = columns;
        this.setLayout(new GridLayout(rows,columns));
        for( int r = 0; r < cells.length; r++ ) {
            for (int c = 0; c < cells[r].length; c++) {
                cells[r][c] = new Cell(r, c);
                this.add(cells[r][c]);
                cells[r][c].addActionListener(ah);
            }
        }
    }


    public Boolean setCell(Mark mark, int row, int column)  {
        if (cells[row][column].getContent() == Mark.EMPTY) {
            cells[row][column].setContent(mark);
            return true;
        }else {
            JOptionPane.showMessageDialog(null, "An error occurred: Player already there!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Cell getCell(int row, int column) {
        return cells[row][column];
    }

    public int getRows(){
        return row;
    }
    public int getColumns(){
        return column;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int r = 0; r < cells.length; r++) {
            str.append("|");
            for (int c = 0; c < cells[r].length; c++) {
                switch (cells[r][c].getContent()) {
                    case NOUGHT:
                        str.append("0");
                        break;
                    case CROSS:
                        str.append("X");
                        break;
                    case YELLOW:
                        str.append("Y");
                        break;
                    case RED:
                        str.append("R");
                        break;
                    case BLUE:
                        str.append("B");
                        break;
                    case GREEN:
                        str.append("G");
                        break;
                    case MAGENTA:
                        str.append("M");
                        break;
                    case ORANGE:
                        str.append("O");
                        break;
                    default: //Empty
                        str.append(" ");
                }
                str.append("|");
            }
            str.append("\n");
        }
        return str.toString();
    }


}
                    
