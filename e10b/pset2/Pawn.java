class Pawn extends Piece {
    boolean attackingThisLocation(int indexRow, int indexColumn) {
        int columnDiff = pieceColumn - indexColumn;
        int rowDiff = pieceRow - indexRow;

        // get absolute value of columnDiff and rowDiff (non-negative)
        columnDiff *= columnDiff;
        rowDiff *= rowDiff;

        // Can attack diagonally by one square to the left or right
        if (rowDiff == 1 && columnDiff == 1) {
            return true;
        } else {
            return false;
        }
    }
}
