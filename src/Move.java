public class Move {
    public Pieces killedPiece;
    int oldColumn;
    int oldRow;
    int newColumn;
    int newRow;
    Pieces piece;
    Pieces killedPieces;

    public Move (Board board , Pieces piece , int newColumn , int newRow){
        this.piece=piece;
        this.oldColumn = piece.column;
        this.oldRow = piece.row;
        this.newColumn = newColumn;
        this.newRow = newRow;
        this.killedPieces = board.getPiece(newColumn , newRow);
    }
}
