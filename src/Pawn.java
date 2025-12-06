public class Pawn extends ChessPiece{

    public Pawn (String color){
        super(color);
    }

    public String getColor(){
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7){
            return false;
        }
        if ((line == toLine && column == toColumn)) {
            return false;
        }

        if (color.equals("White")){
            if ((toLine == line + 1) && (toColumn == column)){
                return true;
            }
        } else {if ((toLine == line -1) && (toColumn == column)){
            return true;
        }
        }

        if (color.equals("White")){
            if (line == 1){
                if ((toLine == line + 2) && (toColumn == column)){
                    return true;
                }
            }
            if (chessBoard.board[toLine][toColumn] != null){
                if (chessBoard.board[toLine][toColumn].getColor().equals("Black")) {
                    if ((toLine == line + 1) && (toColumn == column + 1 || toColumn == column - 1)){
                        return true;
                    }
                }
            }
        }
        if (color.equals("Black")){
            if (line == 6){
                if ((toLine == line - 2) && (toColumn == column)){
                    return true;
                }
            }
            if (chessBoard.board[toLine][toColumn] != null){
                if (chessBoard.board[toLine][toColumn].getColor().equals("White")) {
                    if ((toLine == line - 1) && (toColumn == column + 1 || toColumn == column - 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String getSymbol(){
        return "P";
    }
}