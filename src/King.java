public class King extends ChessPiece{

    public King (String color){
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

        int dvizhenieLine = Math.abs(toLine - line);
        int dvizhenieColumn = Math.abs(toColumn - column);
        if ((dvizhenieLine <= 1) && (dvizhenieColumn <= 1)) {
            if (color.equals("White")){
                if (chessBoard.board[toLine][toColumn] != null){
                    if (!chessBoard.board[toLine][toColumn].getColor().equals("Black")) {
                        return false;

                    }

                }
            } else {
                if (chessBoard.board[toLine][toColumn] != null){
                    if (!chessBoard.board[toLine][toColumn].getColor().equals("White")) {
                        return false;

                    }

                }

            }
            if (isUnderAttack(chessBoard, toLine, toColumn)) {
                return false;

            }
            return true;

        } else {
            return false;

        }
    }
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (checkPos(line) && checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return false;
    }
    public String getSymbol(){
        return "K";
    }
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
}