public class Horse extends ChessPiece{

    public Horse (String color){
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
        if ((dvizhenieLine == 1 && dvizhenieColumn == 2) || (dvizhenieLine == 2 && dvizhenieColumn == 1)) {
            return true;
        } else {
            return false;
        }
    }

    public String getSymbol(){
        return "H";
    }
}