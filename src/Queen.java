public class Queen extends ChessPiece {

    public Queen(String color) {
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

        // check if the piece can move diagonally or in a straight line
        int diffLine = Math.abs(toLine - line);
        int diffColumn = Math.abs(toColumn - column);
        if (diffLine != 0 && diffColumn != 0 && diffLine != diffColumn) {
            return false;
        }

        // check if there are no other pieces between current and new position
        if (diffLine != 0 && diffColumn != 0) {
            int i = line < toLine ? line + 1 : line - 1;
            int j = column < toColumn ? column + 1 : column - 1;
            while (i != toLine && j != toColumn) {
                if (chessBoard.board[i][j] != null) {
                    return false;
                }
                if (line < toLine) {
                    i++;
                } else {
                    i--;
                }
                if (column < toColumn) {
                    j++;
                } else {
                    j--;
                }
            }
        } else if (diffLine != 0) {
            int i = line < toLine ? line + 1 : line - 1;
            while (i != toLine) {
                if (chessBoard.board[i][column] != null) {
                    return false;
                }
                if (line < toLine) {
                    i++;
                } else {
                    i--;
                }
            }
        } else {
            int j = column < toColumn ? column + 1 : column - 1;
            while (j != toColumn) {
                if (chessBoard.board[line][j] != null) {
                    return false;
                }
                if (column < toColumn) {
                    j++;
                } else {
                    j--;
                }
            }
        }

        // check if the new position does not have piece with same color
        if (chessBoard.board[toLine][toColumn] == null) {
            return true;
        } else if (!chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}