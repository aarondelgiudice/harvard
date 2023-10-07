class Queen extends Piece {
    boolean attackingThisLocation(int indexRow, int indexColumn) {
        int columnDiff = pieceColumn - indexColumn;
        int rowDiff = pieceRow - indexRow;

        // a queen can move like a rook (horizontally) or a bishop (diagonally)
        boolean rookMove = (indexRow == pieceRow && indexColumn != pieceColumn) ||
                (indexColumn == pieceColumn && indexRow != pieceRow);

        boolean bishopMove = (columnDiff + rowDiff == 0) || (columnDiff == rowDiff);

        return rookMove || bishopMove;
    }
}
