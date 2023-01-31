class Jug{
  //instance variables
  private int capacity;
  private int volume;
  private int jugNumber;

  //no static class variables

  //constructor
  public Jug (int jugNumber, int volume, int capacity){
    if (volume > capacity){
      volume = capacity;
    }
    if (volume < 0){
      volume = 0;
    }
    if (capacity < 0){
      capacity = 0;
    }
    this.jugNumber = jugNumber;
    this.capacity = capacity;
    this.volume = volume;
  }

  public String toString(){
    return this.jugNumber + ": (" + this.volume + "/" + this.capacity + ")";
  }

  public void pourFrom(Jug fillJug){
    while (!(this.isEmpty() ||  fillJug.isFull())){
      this.volume --;
      fillJug.volume ++;
    }
  }

  public int getVolume(){
    return this.volume;
  }
  public int getCapacity(){
    return this.capacity;
  }
  private boolean isEmpty(){
    return (this.volume == 0);
  }
  private boolean isFull(){
    return (this.capacity == this.volume);
  }
}