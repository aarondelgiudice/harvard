class Rook extends Piece {
    boolean attackingThisLocation(int indexRow, int indexColumn) {
        if ((indexRow == pieceRow && indexColumn != pieceColumn) ||
                (indexColumn == pieceColumn && indexRow != pieceRow)) {
            return true;
        } else {
            return false;
        }
    }
}