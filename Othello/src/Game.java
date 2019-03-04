import java.util.ArrayList;

public class Game {

    public char[][] board = new char[][]{
      {'-', '-', '-', 'o', '-', '-', '-', '-'},
      {'-', '-', 'o', 'x', 'x', '-', '-', '-'},
      {'-', '-', 'x', 'x', 'x', '-', '-', '-'},
      {'-', '-', '-', 'x', '-', '-', '-', '-'},
      {'-', 'x', 'x', 'x', 'o', '-', '-', '-'},
      {'-', '-', '-', 'x', '-', '-', '-', '-'},
      {'-', '-', '-', 'x', '-', '-', '-', '-'},
      {'-', '-', '-', '-', '-', '-', '-', '-'}
  };

  public ArrayList<Move> moves = new ArrayList<>();

  public void initMoves(){
    for (int i = 0; i < 8; i++){
      for (int j = 0; j < 8; j++){
        if (board[i][j] == 'o'){
          checkRight(i, j);
          checkLeft(i, j);
          checkUp(i, j);
          checkDown(i, j);
        }
      }
    }

  }

  public void printMove(){
    System.out.println(moves.toString());
  }

  public void getBestMove(){
    int largest = Integer.MIN_VALUE;
    Move best = new Move(0,0,0);
    for (int i = 0; i < moves.size(); i++){
      if (moves.get(i).getSpotsFlipped() > largest){
        largest = moves.get(i).getSpotsFlipped();
        best = moves.get(i);
      }
    }

    System.out.println("X Position: " + best.getX());
    System.out.println("Y Position: " + best.getY());
    System.out.println("X's Flipped: " + largest);


  }

  public void checkRight(int row, int col){
    int count = 0;
    for (int i = col; i < 8; i++){
      if (board[row][i] == 'x'){
        count++;
      }
      else if (board[row][i] == '-' && count > 0){
        moves.add(new Move(row, i, count));
        break;
      }
    }
  }

  public void checkLeft(int row, int col){
    int count = 0;
    for (int i = col; i > 0; i--){
      if (board[row][i] == 'x'){
        count++;
      }
      else if (board[row][i] == '-' && count > 0){
        moves.add(new Move(row, i, count));
        break;
      }
    }
  }

  public void checkUp(int row, int col){
    int count = 0;
    for (int i = row; i > 0; i--){
      if (board[i][col] == 'x'){
        count++;
      }
      else if (board[i][col] == '-' && count > 0){
        moves.add(new Move(i, col, count));
        break;
      }
    }
  }

  public void checkDown(int row, int col){
    int count = 0;
    for (int i = row; i < 8; i++){
      if (board[i][col] == 'x'){
        count++;
      }
      else if (board[i][col] == '-' && count > 0){
        moves.add(new Move(i, col, count));
        break;
      }
    }
  }


}
