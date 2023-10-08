// Chessboard.java
// Unit 5 lecture notes

/**
 *  Calculates and displays which positions
 *  a chess piece (for now, just bishops and knights)
 *  can "attack" from a given location on a standard
 *  8 by 8 chessboard.
 *
 *  @author  Dr. H.H. Leitner
 *  @version Last modified:  January 16, 2020
 */

import java.util.*;

class Chessboard {
    /**
     * Locates the piece on the board, showing all possible moves, and
     * places a 'b' or 'w' for the remaining squares.
     */

    public static void main(String[] args) {
        Piece p;
        Scanner keyboard = new Scanner(System.in);
        System.out
                .print("Would you like to play with a Bishop (B), or a King (K), Knight (N), Pawn (P), Queen (Q), or Rook (R)? ");
        String answer = keyboard.nextLine();

        if (answer.charAt(0) == 'b' || answer.charAt(0) == 'B')
            p = new Bishop();
        else if (answer.charAt(0) == 'k' || answer.charAt(0) == 'K')
            p = new King();
        else if (answer.charAt(0) == 'p' || answer.charAt(0) == 'P')
            p = new Pawn();
        else if (answer.charAt(0) == 'q' || answer.charAt(0) == 'Q')
            p = new Queen();
        else if (answer.charAt(0) == 'r' || answer.charAt(0) == 'R')
            p = new Rook();
        else
            p = new Knight();

        p.placeOnChessBoard();

        System.out.println("\n  1 2 3 4 5 6 7 8"); // number the columns

        for (int indexRow = 1; indexRow <= 8; indexRow++) {
            System.out.print(indexRow); // number the rows
            for (int indexColumn = 1; indexColumn <= 8; indexColumn++) {
                if (p.attackingThisLocation(indexRow, indexColumn))
                    System.out.print(" *");
                else if ((indexColumn + indexRow) % 2 == 0)
                    System.out.print(" b");
                else
                    System.out.print(" w");
            }
            System.out.println();
        }
        System.out.println();

        keyboard.close();
    }
}
