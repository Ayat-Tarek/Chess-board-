public class Player {
    public String name;
    public boolean isWhite;
    public int totalScore = 0;

    Board board;
    Move move;

  // King king ;
  // KingCheck kingCheck;
    public Player( Board board , Move move , boolean isWhite ){
        this.board = board;
        this.move = move;
       // this.king = king;
        this.isWhite= isWhite;

    }

  /*  public boolean inCheckMate(Move move , KingCheck kingCheck , King king){
        if (kingCheck.isKingChecked(move) && !(king.hasEscapeMoves())){
            return true; // launch window game over before return true
        }
        return false;
    }*/
   /* public boolean hasWon(Move move){
        if (! this.inCheckMate(move)){
            return true;
        }
        return false;
    }*/

    public int calculateScore(){
        // law el palyer hasWon B2a hn call el function dy;
        // law he didn't won hayfdl bl score el a2deem bta3o 3ady
        totalScore+= 100;
        return totalScore;
    }

}
