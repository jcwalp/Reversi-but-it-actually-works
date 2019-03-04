public class Move {

  private int x;
  private int y;
  private int spotsFlipped;

  public Move(int x, int y, int sF){
    this.x = x;
    this.y = y;
    this.spotsFlipped = sF;
  }

  public String toString(){
    String a = Integer.toString(this.x);
    String b = Integer.toString(this.y);
    String c = Integer.toString(this.spotsFlipped);
    String res = a + b + c;
    return res;
  }

  public int getSpotsFlipped(){
    return this.spotsFlipped;
  }

  public int getX(){
    return this.x;
  }

  public int getY(){
    return this.y;
  }
}
