public class Game{
  private int[] capacity = {8, 5, 3};
  private int[] filled = {8, 0, 0};
  public int i = 0;
  public int jugSpilled = 0;
  public int jugRecieved = 0;
  private int transfer = 0;

  public String intro(){
    return i++ +" 0:("+filled[0]+"/"+capacity[0]+") 1:("+filled[1]+"/"+capacity[1]+") 2:("+filled[2]+"/"+capacity[2]+")";
  }
  
  public void jugChange(int jugSpilled, int jugRecieved){
    this.jugSpilled = jugSpilled;
    this.jugRecieved = jugRecieved;
    if ((capacity[jugRecieved] - filled[jugRecieved]) > filled[jugSpilled]){
      filled[jugSpilled] = 0;
      filled[jugRecieved] = filled[jugRecieved] + filled[jugSpilled];
    }
    if (capacity[jugRecieved] > filled[jugRecieved]){
      transfer = capacity[jugRecieved] - filled[jugRecieved];
      filled[jugRecieved] = capacity[jugRecieved];
      filled[jugSpilled]= filled[jugSpilled] - transfer;
    }
  }

  public String info(){
    if (filled[0] == 4 && filled[1] == 4 && filled[2] == 0){
      return "congrats, you solved it in "+i+"moves!!";
      /*return "high score: "+ this.Highscore;*/
    }
    else {
      return "spill from jug: "+jugSpilled+
      "\ninto jug: "+jugRecieved+"\n"
      + i++ +" 0:("+filled[0]+"/"+capacity[0]+") 1:("+filled[1]+"/"+capacity[1]+") 2:("+filled[2]+"/"+capacity[2]+")";
    }
  }
}