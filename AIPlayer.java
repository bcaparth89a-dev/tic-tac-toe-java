public class AIPlayer {

    public static int[] findBestMove(char[][] board){

        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                if(board[i][j]==' '){

                    board[i][j] = 'O';

                    int score = minimax(board,false);

                    board[i][j] = ' ';

                    if(score > bestScore){

                        bestScore = score;
                        move[0] = i;
                        move[1] = j;

                    }
                }

            }
        }

        return move;
    }

    private static int minimax(char[][] board, boolean isMax){

        char winner = GameLogic.checkWinner(board);

        if(winner == 'O') return 10;
        if(winner == 'X') return -10;

        if(GameLogic.isBoardFull(board)) return 0;

        if(isMax){

            int bestScore = Integer.MIN_VALUE;

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){

                    if(board[i][j]==' '){

                        board[i][j] = 'O';

                        int score = minimax(board,false);

                        board[i][j] = ' ';

                        bestScore = Math.max(score,bestScore);

                    }
                }
            }

            return bestScore;
        }

        else{

            int bestScore = Integer.MAX_VALUE;

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){

                    if(board[i][j]==' '){

                        board[i][j] = 'X';

                        int score = minimax(board,true);

                        board[i][j] = ' ';

                        bestScore = Math.min(score,bestScore);

                    }
                }
            }

            return bestScore;
        }
    }
}