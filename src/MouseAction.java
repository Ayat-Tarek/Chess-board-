import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;

public class MouseAction extends MouseAdapter {
    Board board;
    Timer timer;
    public MouseAction(Board board){
        this.board = board;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int column = e.getX()/ board.spotSize;
        int row = e.getY()/ board.spotSize;
        Pieces piece = board.getPiece(column,row);
        if(piece != null){
            board.selectedPiece = piece;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(board.selectedPiece != null){
            board.selectedPiece.position_x = e.getX()* board.spotSize/2;
            board.selectedPiece.position_y = e.getY()* board.spotSize/2;
            board.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int column = e.getX()/ board.spotSize;
        int row = e.getY()/ board.spotSize;
        if(board.selectedPiece != null){
            Move move = new Move(board, board.selectedPiece ,column,row);
                if(board.isValidMove(move)){
                    board.makeMove(move);
            }else {
                    board.selectedPiece.position_x = board.selectedPiece.column * board.spotSize;
                    board.selectedPiece.position_y = board.selectedPiece.row * board.spotSize;
                }
        }
        board.selectedPiece = null;
        board.repaint();
        }
}

