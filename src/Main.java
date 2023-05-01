import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;


public class Main {
    public  static Timer timer;
    static int  player1Time = 600;
    static int player2Time = 600;
    static int delay=1000;
    public Main() {
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();


        //add background to the frame
        ImageIcon BackgroundImage = new ImageIcon("D:\\background.jpg");
        Image img = BackgroundImage.getImage();
        Image temp_img = img.getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
        BackgroundImage = new ImageIcon(temp_img);
        JLabel BackGround = new JLabel();
        BackGround.setIcon(BackgroundImage);
        BackGround.setBounds(0, 0, 1000, 800);
        frame.add(BackGround);

        //create a panel to add class board on it
        JPanel backgroundOfBoard = new JPanel();
        backgroundOfBoard.setLayout( new GridBagLayout());
        backgroundOfBoard.setBounds(200, 150, 600, 600);
        backgroundOfBoard.setBackground(new Color(139, 135, 141));

       //set frame characteristics
        ImageIcon image = new ImageIcon("frame icon.jpg");
        frame.setIconImage(image.getImage());
        frame.setMinimumSize(new Dimension(1000, 800));
        frame.setLocationRelativeTo((Component) null);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(false);
        frame.setTitle("Team Eleven Chess engine");
        frame.pack();

        //create two labels for player1/2 to show beside the board
        ImageIcon imageForPlayer_1 = new ImageIcon("D:\\player 2.png");
        Image img1 = imageForPlayer_1.getImage();
        Image temp_img1 = img1.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        imageForPlayer_1 = new ImageIcon(temp_img1);
        JLabel player_1 = new JLabel();
        player_1.setText("Player 1");
        player_1.setIcon(imageForPlayer_1);
        player_1.setBounds(60, 40, 130, 130);
        player_1.setHorizontalTextPosition(JLabel.CENTER);
        player_1.setVerticalTextPosition(JLabel.BOTTOM);
        player_1.setForeground(new Color(0xFFFFFFFF));
        player_1.setFont(new Font("MV Boli", Font.PLAIN, 24));

        ImageIcon imageForPlayer_2 = new ImageIcon("D:\\player 1.png");
        Image img2 = imageForPlayer_2.getImage();
        Image temp_img2 = img2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        imageForPlayer_2 = new ImageIcon(temp_img2);
        JLabel player_2 = new JLabel();
        player_2.setBounds(850, 40, 130, 130);
        player_2.setText("Player 2");
        player_2.setIcon(imageForPlayer_2);
        player_2.setHorizontalTextPosition(JLabel.CENTER);
        player_2.setVerticalTextPosition(JLabel.BOTTOM);
        player_2.setForeground(new Color(0xFFFFFFFF));
        player_2.setFont(new Font("MV Boli", Font.PLAIN, 24));

        //create a label to add timer contents to it
        JLabel backgroundOfTimer1=new JLabel("",null,JLabel.CENTER);
        backgroundOfTimer1.setBounds(210,40,200,100);
        backgroundOfTimer1.setLayout(new GridLayout(2,1));

        JLabel backgroundOfTimer2=new JLabel("",null,JLabel.CENTER);
        backgroundOfTimer2.setBounds(580,60,200,100);
        backgroundOfTimer2.setLayout(new GridLayout(2,1));

        //create the timer
        JLabel player1Label = new JLabel("PLAYER_1: " + player1Time+" Sec");
        backgroundOfTimer1.add(player1Label);

        RoundButton player1Button = new RoundButton("player 1", 20, new Color(121, 160, 176), new Color(0xD01A356C));
        backgroundOfTimer1.add(player1Button);

        RoundButton player2Button = new RoundButton("player 2", 20, new Color(121, 160, 176), new Color(0xD01A356C));
        backgroundOfTimer2.add(player2Button);

        JLabel player2Label = new JLabel("PLAYER_2: " + player2Time+" Sec");
        backgroundOfTimer2.add(player2Label);

        player1Button.setFocusable(false);
        player2Button.setFocusable(false);
        player1Button.setFont(new Font("MV Boli",Font.BOLD,25));
        player2Button.setFont(new Font("MV Boli",Font.BOLD,25));
        player1Label.setFont(new Font("MV Boli",Font.BOLD,18));
        player2Label.setFont(new Font("MV Boli",Font.BOLD,18));
        player1Label.setForeground(new Color(0xFFFFFF));
        player2Label.setForeground(new Color(0xFFFFFF));
        player1Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player1Time -= delay / 1000;
                player1Label.setText("PLAYER_1: " + player1Time+" Sec");
                player2Label.setText("PLAYER_2: " + player2Time+" Sec");
                timer.restart();
            }
        });
        player2Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player2Time -= delay / 1000;
                player2Label.setText("PLAYER_2: "  + player2Time+" Sec");
                player1Label.setText("PLAYER_1: "  + player1Time+" Sec");
                timer.restart();
            }
        });

        timer = new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (player1Button.isEnabled()) {
                    player1Time -= delay / 1000;
                    player1Label.setText("PLAYER_1: "  + player1Time+" Sec");
                }
                else  {
                    player2Time -= delay / 1000;
                    player2Label.setText("PLAYER_2: " + player1Time+" Sec");

                }
                if (player1Time <= 0) {
                    JOptionPane.showMessageDialog(null, "Player 2 wins!");
                    timer.stop();
                } else if (player2Time <= 0) {
                    JOptionPane.showMessageDialog(null, "Player 1 wins!");
                    timer.stop();

                }

            }

        });


        JPanel board = new Board(frame);
        BackGround.add(backgroundOfBoard);
        BackGround.add(backgroundOfTimer1);
        BackGround.add(backgroundOfTimer2);
        backgroundOfBoard.add(board);
        BackGround.add(player_1);
        BackGround.add(player_2);
        frame.setVisible(true);
        }

    }
