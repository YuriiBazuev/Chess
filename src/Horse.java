public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        // check if the position to move is within the board
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        // check if the piece can move only in L shape
        int diffLine = Math.abs(toLine - line);
        int diffColumn = Math.abs(toColumn - column);
        if ((diffLine == 2 && diffColumn == 1) || (diffLine == 1 && diffColumn == 2)) {

            // check if the new position does not have piece with same color
            if (chessBoard.board[toLine][toColumn] == null) {
                return true;
            } else if (!chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}