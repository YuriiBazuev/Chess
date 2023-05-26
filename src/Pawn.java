public class Pawn extends ChessPiece {

    public Pawn(String color) {
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

        // check if the new position is the same as the current position
        if (line == toLine && column == toColumn) {
            return false;
        }

        // check if the piece can only move forward
        int diffLine = toLine - line;
        if (super.color.equals("White") && diffLine < 1) {
            return false;
        }
        if (super.color.equals("Black") && diffLine > -1) {
            return false;
        }

        // check if the piece can move 2 lines for its first move
        if (Math.abs(diffLine) > 2) {
            return false;
        }
        if ((line != 1 && super.color.equals("White")) || (line != 6 && super.color.equals("Black"))) {
            if (Math.abs(diffLine) == 2) {
                return false;
            }
        }

        // check if the new position does not have piece with same color
        if (chessBoard.board[toLine][toColumn] == null) {

            // check if the new position is 1 line forward
            if (Math.abs(diffLine) == 1) {
                return true;

                // if the new position is 2 lines forward, check if the previous line has no piece
            } else if (Math.abs(diffLine) == 2) {
                if (super.color.equals("White") && chessBoard.board[toLine + 1][toColumn] == null) {
                    return true;
                } else if (super.color.equals("Black") && chessBoard.board[toLine - 1][toColumn] == null) {
                    return true;
                }
            }

            // if the new position has piece with opposite color, can move only diagonally
        } else if (!chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            int diffColumn = Math.abs(toColumn - column);
            if (diffLine == 1 && diffColumn == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}