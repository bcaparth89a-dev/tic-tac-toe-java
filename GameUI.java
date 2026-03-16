import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameUI {

    JFrame frame;
    JButton[][] buttons = new JButton[3][3];

    char[][] board = new char[3][3];

    char player = 'X';

    JLabel status;

    boolean vsAI = true;

    int moves = 0;

    public GameUI(){

        frame = new JFrame("Tic Tac Toe Pro");
        frame.setSize(500,550);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        status = new JLabel("Player Turn: X",JLabel.CENTER);
        status.setFont(new Font("Arial",Font.BOLD,22));

        frame.add(status,BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(3,3));

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                board[i][j]=' ';

                JButton btn = new JButton("");

                btn.setFont(new Font("Arial",Font.BOLD,60));

                buttons[i][j] = btn;

                int r=i,c=j;

                btn.addActionListener(e -> handleMove(r,c));

                panel.add(btn);
            }
        }

        frame.add(panel,BorderLayout.CENTER);

        JButton restart = new JButton("Restart");

        restart.addActionListener(e -> reset());

        frame.add(restart,BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void handleMove(int r,int c){

        if(board[r][c] != ' ')
            return;

        board[r][c] = player;
        buttons[r][c].setText(String.valueOf(player));

        SoundUtil.click();

        moves++;

        if(checkGame())
            return;

        switchPlayer();

        if(vsAI && player=='O'){

            int[] move = AIPlayer.findBestMove(board);

            handleMove(move[0],move[1]);
        }
    }

    private void switchPlayer(){

        player = (player=='X') ? 'O':'X';

        status.setText("Player Turn: "+player);
    }

    private boolean checkGame(){

        char winner = GameLogic.checkWinner(board);

        if(winner!=' '){

            JOptionPane.showMessageDialog(frame,"Player "+winner+" Wins!");

            reset();

            return true;
        }

        if(GameLogic.isBoardFull(board)){

            JOptionPane.showMessageDialog(frame,"Draw!");

            reset();

            return true;
        }

        return false;
    }

    private void reset(){

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                board[i][j]=' ';
                buttons[i][j].setText("");
            }
        }

        player='X';
        moves=0;

        status.setText("Player Turn: X");
    }
}