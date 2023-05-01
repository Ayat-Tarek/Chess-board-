import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Pieces extends JLabel {
    int position_x;
    int position_y;
    int row;
    int column;
    boolean isWhite;
    String pieceName;
    Image pieceImage;
    Board board;
   BufferedImage piecesImage;
    {
        try {
            piecesImage = ImageIO.read(ClassLoader.getSystemResourceAsStream("resources/"+ "image.png"));
        } catch (IOException e) {
            e.getStackTrace();
            e.printStackTrace();
        }
    }

    protected int piecesImageScale = piecesImage.getWidth()/6;
    public Pieces(Board board) {
        this.board = board;
    }

    public void paint(Graphics2D g2d){
        g2d.drawImage(pieceImage,position_x,position_y,null);
    }

    }

