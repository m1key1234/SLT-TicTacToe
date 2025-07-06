package at.technikum;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cells[i][j] = ' ';
    }

    public void print() {
        System.out.println("   0   1   2");
        System.out.println("  -----------");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] == ' ' ? "  " : cells[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  -----------");
    }

    public char getCells(int i, int i1) {
        return cells[i][i1]; }

    public boolean hasWinner(char marker) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == marker && cells[i][1] == marker && cells[i][2] == marker) return true;
            if (cells[0][i] == marker && cells[1][i] == marker && cells[2][i] == marker) return true;
        }
        if (cells[0][0] == marker && cells[1][1] == marker && cells[2][2] == marker) return true;
        if (cells[0][2] == marker && cells[1][1] == marker && cells[2][0] == marker) return true;
        return false;
    }
}