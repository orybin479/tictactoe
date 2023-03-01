package src.src.games.boards;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton{

    private Mark content;
    private int row, column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        content = Mark.EMPTY;
    }

    public Mark getContent() {
        return content;
    }

    public void setContent(Mark content) {
        this.content = content;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int offset = 5;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));

        switch (content) {
            case NOUGHT: //Draw O
                g2.setColor(Color.RED);
                g2.drawOval(offset, offset,
                        this.getWidth() - offset * 2,
                        this.getHeight() - offset * 2);
                break;

            case CROSS: //Draw X
                g2.setColor(Color.BLACK);
                g2.drawLine(offset, offset,
                        this.getWidth() - offset,
                        this.getHeight() - offset);
                g2.drawLine(this.getWidth() - offset,
                        offset, offset,
                        this.getHeight() - offset);
                break;
        }
    }


}





