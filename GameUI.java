import javax.swing.*;
import java.awt.*;

public class GameUI {

    JFrame frame;
    JButton[][] buttons = new JButton[3][3];
    char[][] board = new char[3][3];

    char player = 'X';
    boolean vsAI = false;

    JLabel status;
    JLabel scoreLabel;

    int xWins = 0;
    int oWins = 0;
    int draws = 0;

    public GameUI(){

        frame = new JFrame("Tic Tac Toe PRO");
        frame.setSize(500,650);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TOP PANEL
        JPanel top = new JPanel(new GridLayout(3,1));

        status = new JLabel("Select Mode", JLabel.CENTER);
        status.setFont(new Font("Arial",Font.BOLD,20));

        scoreLabel = new JLabel("Score → X:0  O:0  Draw:0", JLabel.CENTER);
        scoreLabel.setFont(new Font("Arial",Font.PLAIN,16));

        JPanel modePanel = new JPanel();

        JButton pvp = new JButton("Player vs Player");
        JButton ai = new JButton("Player vs AI");

        pvp.addActionListener(e -> {
            vsAI = false;
            resetBoard();
            status.setText("Player X Turn");
        });

        ai.addActionListener(e -> {
            vsAI = true;
            resetBoard();
            status.setText("Player X Turn (AI Mode)");
        });

        modePanel.add(pvp);
        modePanel.add(ai);

        top.add(status);
        top.add(scoreLabel);
        top.add(modePanel);

        frame.add(top,BorderLayout.NORTH);

        // BOARD
        JPanel panel = new JPanel(new GridLayout(3,3));

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                board[i][j] = ' ';

                JButton btn = new JButton("");
                btn.setFont(new Font("Arial",Font.BOLD,60));

                int r=i,c=j;

                btn.addActionListener(e -> handleMove(r,c));

                buttons[i][j] = btn;
                panel.add(btn);
            }
        }

        frame.add(panel,BorderLayout.CENTER);

        // BOTTOM
        JButton reset = new JButton("Restart Game");

        reset.addActionListener(e -> resetBoard());

        frame.add(reset,BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void handleMove(int r,int c){

        if(board[r][c] != ' ') return;

        board[r][c] = player;
        buttons[r][c].setText(String.valueOf(player));

        SoundUtil.click();

        if(checkGame()) return;

        switchPlayer();

        if(vsAI && player=='O'){
            int[] move = AIPlayer.findBestMove(board);
            handleMove(move[0],move[1]);
        }
    }

    private void switchPlayer(){
        player = (player=='X') ? 'O':'X';
        status.setText("Player " + player + " Turn");
    }

    private boolean checkGame(){

        char winner = GameLogic.checkWinner(board);

        if(winner!=' '){

            if(winner=='X') xWins++;
            else oWins++;

            updateScore();

            JOptionPane.showMessageDialog(frame,"Player "+winner+" Wins!");

            resetBoard();
            return true;
        }

        if(GameLogic.isBoardFull(board)){

            draws++;
            updateScore();

            JOptionPane.showMessageDialog(frame,"Draw!");

            resetBoard();
            return true;
        }

        return false;
    }

    private void updateScore(){
        scoreLabel.setText("Score → X:"+xWins+"  O:"+oWins+"  Draw:"+draws);
    }

    private void resetBoard(){

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=' ';
                buttons[i][j].setText("");
            }
        }

        player='X';
        status.setText("Player X Turn");
    }
}