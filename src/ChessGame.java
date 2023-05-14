//enum GameStatus { Active , GameOver };
/*public class ChessGame {
    Player player1 = new Player();
    Player player2 = new Player();
    Player currentPlayer;
    Board board;
    Move move;
    GameStatus gameStatus;
    public ChessGame(Board board , Move move){
        player1.isWhite=true;
        player2.isWhite=false;
        this.board=board;
        this.move=move;
        if (player1.isWhite){
            currentPlayer=player1;
        }else currentPlayer=player2;

        if(!board.selectedPiece.isWhite){
            board.selectedPiece=null;
        }
    }

    public boolean isGameOver(){
        if(currentPlayer.inCheckMate(move)){
            gameStatus=GameStatus.GameOver;
            return true;
        }
        return false;
    }

    public void isInCheck(){
       if(currentPlayer.kingCheck.isKingChecked(move)){
           System.out.println("check!");
        }
    }

    public void switchTurn(){
        if(currentPlayer==player1){
            currentPlayer=player2;
        }else currentPlayer=player1;
    }

    public void Play(){
        while(gameStatus==GameStatus.Active){
            if(this.isGameOver()){
                promotionWindow promotionWindow = new promotionWindow(board,move);
            }
            switchTurn();
        }
    }
}*/
