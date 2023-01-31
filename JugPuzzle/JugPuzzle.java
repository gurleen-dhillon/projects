import java.util.*;
class JugPuzzle{
  private ArrayList<Jug> Jugs;

  private int moves;
  private boolean isWon;

  private static int highScore = 10000;

  public JugPuzzle(){
    this.Jugs = new ArrayList<Jug>();

    this.Jugs.add(new Jug(0, 8, 8));
    this.Jugs.add(new Jug(1, 0, 5));
    this.Jugs.add(new Jug(2, 0, 3));
    this.moves = 0;
    this.isWon = false;
  }

  public String toString(){
    return this.moves +
    " 0: (" + this.Jugs.get(0).getVolume() + "/8) " +
    "1: (" + this.Jugs.get(1).getVolume() + "/5) " +
    "2: (" + this.Jugs.get(2).getVolume() + "/3) ";
  }

  public void startGame(){
    while(!this.isWon){
      System.out.println(this.toString());
      this.getMove();
    }
    System.out.println("Congrats, you solved it in " + this.moves + " moves!!");
    setHighScore(this.moves);
  }
  
  private void getMove(){
    Scanner moves = new Scanner(System.in);
    System.out.print("Spill from jug: ");
    int move1 = moves.nextInt();
    System.out.print("into jug: ");
    int move2 = moves.nextInt();

    Jugs.get(move1).pourFrom(Jugs.get(move2));
    this.moves ++;
    this.setWinState();
  }

  private void setWinState(){
    if (this.Jugs.get(0).getVolume() == 4 && this.Jugs.get(1).getVolume() == 4){
     this.isWon = true;
    }
  }

  private static void setHighScore(int currentScore){
    if (currentScore < highScore){
      highScore = currentScore;
    }
    System.out.println( "Congrats, your new high score is " + highScore);
  }
}