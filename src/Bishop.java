public class Bishop extends ChessPiece{

    public Bishop (String color){
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
        if (dvizhenieLine != dvizhenieColumn) {
            return false;
        }
        int stepLine = 0;
        int stepCol = 0;
        if (toLine > line){
            stepLine += 1;
        }
        if (toLine < line){
            stepLine -= 1;
        }
        if (toColumn > column){
            stepCol += 1;
        }
        if (toColumn < column){
            stepCol -= 1;
        }
        int curLine = line + stepLine;
        int curCol = column + stepCol;
        while ((curLine != toLine) || (curCol != toColumn)){
            if (chessBoard.board[curLine][curCol] != null){
                return false;
            }
            curLine += stepLine;
            curCol += stepCol;
        }
        if (color.equals("White")){
            if (chessBoard.board[toLine][toColumn] != null){
                if (chessBoard.board[toLine][toColumn].getColor().equals("Black")) {
                    return true;
                }
            } else{
                return true;
            }
        }
        if (color.equals("Black")){
            if (chessBoard.board[toLine][toColumn] != null){
                if (chessBoard.board[toLine][toColumn].getColor().equals("White")) {
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public String getSymbol(){
        return "B";
    }
}
