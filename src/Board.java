
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Board extends JPanel{

    private JFrame frame;
    int column = 8;
    int row = 8;
    public int spotSize = 75;
    JLabel whiteKilledLabel;
    JLabel blackKilledLabel;
    JPanel whiteKilledPanel;
    JPanel blackKilledPanel;

    ArrayList<Pieces> pieceList = new ArrayList<>();
    public Pieces selectedPiece;
    MouseAction mouseAction = new MouseAction(this);

    public Board(JFrame frame){

        this.frame = frame;
        this.setPreferredSize(new Dimension(row*spotSize , column*spotSize));
        addPieces();

        //set the panel to put the white killed pieces on it
        whiteKilledPanel = new JPanel();
        whiteKilledPanel.setPreferredSize(new Dimension(120, 350));
        whiteKilledPanel.setBackground( new Color(6, 43, 61));
        whiteKilledPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,200));

        whiteKilledLabel = new JLabel();
        whiteKilledLabel.setPreferredSize(new Dimension(120, 350));
        whiteKilledLabel.setLayout(new GridLayout(8,2));
        whiteKilledPanel.add(whiteKilledLabel);

        // set the panel to add the black killed pieces on it
        blackKilledPanel = new JPanel();
        blackKilledPanel.setPreferredSize(new Dimension(120, 350));
        blackKilledPanel.setBackground(new Color(14, 104, 141, 255));
        blackKilledPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10,200));

        blackKilledLabel = new JLabel();
        blackKilledLabel.setPreferredSize(new Dimension(120, 350));
        blackKilledLabel.setLayout(new GridLayout(8,2));
        blackKilledPanel.add(blackKilledLabel);

        //create a panel that hold the white, black killed panels and the chess board panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(whiteKilledPanel,BorderLayout.EAST);
        mainPanel.add(this,BorderLayout.CENTER);
        mainPanel.add(blackKilledPanel,BorderLayout.WEST);

        frame.pack();
        frame.add(mainPanel);
        frame.setVisible(true);
        this.addMouseListener(mouseAction);
        this.addMouseMotionListener(mouseAction);
    }

    //method to see if there is a piece in a specific row and column and return it if exists
    public Pieces getPiece( int column , int row){
        for(Pieces piece : pieceList){
            if(piece.column == column && piece.row == row){
                return piece;
            }
        }return null;
    }

    //method to check if the move is valid depending on the  piece color and the available rows and columns
    public boolean isValidMove(Move move){
        if (sameColor(move.piece , move.killedPieces)) {
            return false;
        }if (selectedPiece.column>column || selectedPiece.row>row ){
                return false;
            }
        return true;
    }

    //method to make the move if it is valid and kill the piece that was on that spot if there was any
    public void makeMove(Move move){
        move.piece.column = move.newColumn;
        move.piece.row = move.newRow;
        move.piece.position_x = move.newColumn * spotSize;
        move.piece.position_y = move.newRow * spotSize;
        kill(move);
        }

      //method to remove the killed pieces from the chess board and add it to their corresponding panels
    public void kill(Move move){

        if (move.killedPieces != null) {
            if (move.killedPieces.isWhite) {
                System.out.println(move.killedPieces.pieceName);
                    if(move.killedPieces.pieceName == "knight"){
                    ImageIcon whiteKnight = new ImageIcon("White Knight.png");
                        Image img2 = whiteKnight.getImage();
                        Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel WhiteKnight = new JLabel(new ImageIcon(temp_img2));
                    whiteKilledLabel.add(WhiteKnight);
                    frame.setVisible(true);
                }
              else if(move.killedPieces.pieceName == "king"){
                    ImageIcon whiteKing = new ImageIcon("White King.png");
                        Image img2 = whiteKing.getImage();
                        Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                        JLabel WhiteKing = new JLabel(new ImageIcon(temp_img2));
                    whiteKilledLabel.add(WhiteKing);
                    frame.setVisible(true);

                }
                else if(move.killedPieces.pieceName == "Queen"){
                    ImageIcon whiteQueen = new ImageIcon("White Queen.png");
                        Image img2 = whiteQueen.getImage();
                        Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                        JLabel WhiteQueen = new JLabel(new ImageIcon(temp_img2));
                        whiteKilledLabel.add(WhiteQueen);
                    frame.setVisible(true);
                }
                else if(move.killedPieces.pieceName == "rook"){
                    ImageIcon whiteRook = new ImageIcon("White Rook.png");
                        Image img2 = whiteRook.getImage();
                        Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                        JLabel WhiteRook = new JLabel(new ImageIcon(temp_img2));
                        whiteKilledLabel.add(WhiteRook);
                    frame.setVisible(true);
                }
                else if(move.killedPieces.pieceName == "pawn"){
                    ImageIcon whitePawn = new ImageIcon("White Pawn.png");
                        Image img2 = whitePawn.getImage();
                        Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                        JLabel WhitePawn = new JLabel(new ImageIcon(temp_img2));
                        whiteKilledLabel.add(WhitePawn);
                    frame.setVisible(true);
                }
                 else if(move.killedPieces.pieceName == "Bishop"){
                    ImageIcon whiteBishop = new ImageIcon("White Bishop.png");
                        Image img2 = whiteBishop.getImage();
                        Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                        JLabel WhiteBishop = new JLabel(new ImageIcon(temp_img2));
                        whiteKilledLabel.add(WhiteBishop);
                    frame.setVisible(true);
                }

            } else {
                System.out.println(move.killedPieces.pieceName);
                if(move.killedPieces.pieceName == "knight"){
                    ImageIcon blackKnight = new ImageIcon("Black Knight.png");
                    Image img2 = blackKnight.getImage();
                    Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel BlackKnight = new JLabel(new ImageIcon(temp_img2));
                    blackKilledLabel.add(BlackKnight);
                    frame.setVisible(true);
                }
                else if(move.killedPieces.pieceName == "king"){
                    ImageIcon blackKing = new ImageIcon("Black King.png");
                    Image img2 = blackKing.getImage();
                    Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel BlackKing = new JLabel(new ImageIcon(temp_img2));
                    blackKilledLabel.add(BlackKing);
                    frame.setVisible(true);
                }
                else if(move.killedPieces.pieceName == "Queen"){
                    ImageIcon blackQueen = new ImageIcon("Black Queen.png");
                    Image img2 = blackQueen.getImage();
                    Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel BlackQueen = new JLabel(new ImageIcon(temp_img2));
                    blackKilledLabel.add(BlackQueen);
                    frame.setVisible(true);
                }
                else if(move.killedPieces.pieceName == "rook"){
                    ImageIcon blackRook = new ImageIcon("Black Rook.png");
                    Image img2 = blackRook.getImage();
                    Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel BlackRook = new JLabel(new ImageIcon(temp_img2));
                    blackKilledLabel.add(BlackRook);
                    frame.setVisible(true);
                }
                else if(move.killedPieces.pieceName == "pawn"){
                    ImageIcon blackPawn = new ImageIcon("Black Pawn.png");
                    Image img2 = blackPawn.getImage();
                    Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel BlackPawn = new JLabel(new ImageIcon(temp_img2));
                    blackKilledLabel.add(BlackPawn);
                    frame.setVisible(true);
                }
                else if(move.killedPieces.pieceName == "Bishop"){
                    ImageIcon blackBishop = new ImageIcon("Black Bishop.png");
                    Image img2 = blackBishop.getImage();
                    Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                    JLabel BlackBishop = new JLabel(new ImageIcon(temp_img2));
                    blackKilledLabel.add(BlackBishop);
                    frame.setVisible(true);
                }
            }
        pieceList.remove(move.killedPieces);

    }
    }

    //method to compare the color between the selected piece and the targeted piece
    public boolean sameColor( Pieces p1 , Pieces p2){
        if(p1 == null || p2 == null){
            return false;
        }
        return p1.isWhite == p2.isWhite;
    }

    //method to add the pieces on the chess board
    public void addPieces(){
        pieceList.add(new King(this,4,0,false));
        pieceList.add(new King(this,4,7,true));

        pieceList.add(new Queen(this,3,0,false));
        pieceList.add(new Queen(this,3,7,true));

        pieceList.add(new Bishop(this,2,0,false));
        pieceList.add(new Bishop(this,5,0,false));
        pieceList.add(new Bishop(this,2,7,true));
        pieceList.add(new Bishop(this,5,7,true));

        pieceList.add(new Rook(this,0,0,false));
        pieceList.add(new Rook(this,7,0,false));
        pieceList.add(new Rook(this,0,7,true));
        pieceList.add(new Rook(this,7,7,true));

        pieceList.add(new Knight(this,1,0,false));
        pieceList.add(new Knight(this,6,0,false));
        pieceList.add(new Knight(this,1,7,true));
        pieceList.add(new Knight(this,6,7,true));

        pieceList.add(new Pawn(this,0,1,false));
        pieceList.add(new Pawn(this,1,1,false));
        pieceList.add(new Pawn(this,2,1,false));
        pieceList.add(new Pawn(this,3,1,false));
        pieceList.add(new Pawn(this,4,1,false));
        pieceList.add(new Pawn(this,5,1,false));
        pieceList.add(new Pawn(this,6,1,false));
        pieceList.add(new Pawn(this,7,1,false));
        pieceList.add(new Pawn(this,0,6,true));
        pieceList.add(new Pawn(this,1,6,true));
        pieceList.add(new Pawn(this,2,6,true));
        pieceList.add(new Pawn(this,3,6,true));
        pieceList.add(new Pawn(this,4,6,true));
        pieceList.add(new Pawn(this,5,6,true));
        pieceList.add(new Pawn(this,6,6,true));
        pieceList.add(new Pawn(this,7,6,true));

    }

       //method to paint the board and the pieces
       public void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D) g;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col <8 ; col++) {
                g2d.setColor((row+col)%2==0 ? new Color(255, 252, 252) : new Color(155, 149, 166));
                g2d.fillRect(row*spotSize,col*spotSize,spotSize,spotSize);
            }

           for(Pieces piece : pieceList ){
               if (piece != null && piece.pieceImage != null) {
                piece.paint(g2d);
            }
           }
        }
    }
}




