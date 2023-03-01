package src.src;

import src.src.games.boards.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame {
    private Board gb;
    private int turn;

    public Outcome getOutcome() {

        Mark[] players = new Mark[]{Mark.NOUGHT, Mark.CROSS};

        for (Mark player : players) {
            boolean win;

            // Checking rows
            for (int i = 0; i < gb.getRows(); i++) {
                win = true;
                for (int j = 0; j < gb.getColumns(); j++) {
                    if (gb.getCell(i, j).getContent() != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    if (player == Mark.NOUGHT) {
                        return Outcome.Player1_WIN;
                    } else {
                        return Outcome.Player2_WIN;
                    }
                }
            }

            // Checking columns
            for (int i = 0; i < gb.getRows(); i++) {
                win = true;
                for (int j = 0; j < gb.getColumns(); j++) {
                    if (gb.getCell(j, i).getContent() != player) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    if (player == Mark.NOUGHT) {
                        return Outcome.Player1_WIN;
                    } else {
                        return Outcome.Player2_WIN;
                    }
                }
            }

            // Checking diagonals
            win = true;
            for (int i = 0; i < gb.getRows(); i++) {
                System.out.println(i);
                if (gb.getCell(i, i).getContent() != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                if (player == Mark.NOUGHT) {
                    return Outcome.Player1_WIN;
                } else {
                    return Outcome.Player2_WIN;
                }
            }

            win = true;
            for (int i = 0; i < gb.getRows(); i++) {
                if (gb.getCell(i, gb.getRows() - 1 - i).getContent() != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                if (player == Mark.NOUGHT) {
                    return Outcome.Player1_WIN;
                } else {
                    return Outcome.Player2_WIN;
                }
            }

        }
        for (int i = 0; i < gb.getRows(); i++) {
            for (int j = 0; j < gb.getColumns(); j++) {
                if (gb.getCell(i, j).getContent() == Mark.EMPTY) {
                    return Outcome.CONTINUE;
                }
            }
        }
        return Outcome.TIE;
    }


    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToeGame();
            }
        });

    }
    private void takeTurn(Cell c) {
        // Update the game board with the current player's mark
        Mark curMark = (turn++ % 2 == 0) ? Mark.NOUGHT : Mark.CROSS;
        Boolean isSet = gb.setCell(curMark, c.getRow(), c.getColumn());
        if (isSet){
            Outcome outcome = getOutcome();
            showOutcomeMessage(outcome);
        }else{
            turn--;
        }

    }

    private TicTacToeGame() {
        gb = new Board(3, 3, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Cell c = (Cell) ae.getSource();
                takeTurn(c);
            }
        });
        this.add(gb);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TIC-TAC-TOE");
        this.setSize(300, 300);
        this.setVisible(true);

    }



    private void showOutcomeMessage(Outcome outcome) {
        if (outcome == Outcome.Player1_WIN) {
            JOptionPane.showMessageDialog(this, "Player 1 wins!");
            System.exit(0);
        } else if (outcome == Outcome.Player2_WIN) {
            JOptionPane.showMessageDialog(this, "Player 2 wins!");
            System.exit(0);
        } else if (outcome == Outcome.TIE) {
            JOptionPane.showMessageDialog(this, "It's a tie!");
            System.exit(0);
        }


    }


}



