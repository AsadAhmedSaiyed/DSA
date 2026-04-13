public class Interfaces {
  public static void main(String[] args) {
    Queen q = new Queen();
    q.moves();
  }   
}

interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    @Override
    public void moves(){
        System.out.println("All directions");
    }
}

class Elephant implements ChessPlayer{
    @Override
    public void moves(){
        System.out.println("up, down, left, right");
    }
}

class King implements ChessPlayer{
    @Override
    public void moves(){
        System.out.println("up, down, left, right, 1 step diagonal");
    }
}