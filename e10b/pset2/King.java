//  King.java
//
//  A king can move one square in any direction.
//

class King extends Piece {
    boolean attackingThisLocation(int indexRow, int indexColumn) {
        int columnDiff = pieceColumn - indexColumn;
        int rowDiff = pieceRow - indexRow;

        // get absolute value of columnDiff and rowDiff (non-negative)
        // valid values (-1:1) will be set to 0:1
        // invalid values will be outside of the 0:1 range
        // (I would normally use math.abs() but I was unsure if it was allowed)
        columnDiff *= columnDiff;
        rowDiff *= rowDiff;

        // Sanity checks
        // ColumnDiff and rowDiff cannot both be 0 (cannot attack current space)
        // ColumnDiff and/or rowDiff cannot be greater than 1 (cannot move more than one
        // space)
        if ((columnDiff <= 1 && rowDiff <= 1) && !(columnDiff == 0 && rowDiff == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
