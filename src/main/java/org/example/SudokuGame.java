
package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SudokuGame extends JFrame {
    private int[][] board = new int[9][9];
    private JTextField[][] cells = new JTextField[9][9];
    private JButton checkButton, resetButton;

    public SudokuGame() {
        setTitle("Sudoku");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        initializeBoard();
        fillGrid(gridPanel);

        JPanel buttonPanel = new JPanel();
        checkButton = new JButton("Check");
        resetButton = new JButton("Reset");

        checkButton.addActionListener(e -> checkSolution());
        resetButton.addActionListener(e -> resetGame());

        buttonPanel.add(checkButton);
        buttonPanel.add(resetButton);

        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void initializeBoard() {
        Random rand = new Random();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (rand.nextInt(100) < 30) {
                    board[row][col] = rand.nextInt(9) + 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    private void fillGrid(JPanel panel) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                JTextField cell = new JTextField();
                cell.setHorizontalAlignment(JTextField.CENTER);
                if (board[row][col] != 0) {
                    cell.setText(String.valueOf(board[row][col]));
                    cell.setEditable(false);
                    cell.setBackground(Color.LIGHT_GRAY);
                }
                cells[row][col] = cell;
                panel.add(cell);
            }
        }
    }

    private void checkSolution() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (cells[row][col].isEditable()) {
                    String text = cells[row][col].getText();
                    if (text.isEmpty() || !text.matches("[1-9]")) {
                        JOptionPane.showMessageDialog(this, "Incorrect! Try again.");
                        return;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Congratulations! You solved it.");
    }
//
//    private void resetGame() {
//        initializeBoard();
//        for (int row = 0; row < 9; row++) {
//            for (int col = 0; col < 9; col++) {
//                if (board[row][col] != 0) {
//                    cells[row][col].setText(String.valueOf(board[row][col]));
//                    cells[row][col].setEditable(false);
//                    cells[row][col].setBackground(Color.LIGHT_GRAY);
//                } else {
//                    cells[row][col].setText("");
//                    cells[row][col].setEditable(true);
//                    cells[row][col].setBackground(Color.WHITE);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            new SudokuGame().setVisible(true);
//        });
//    }
}