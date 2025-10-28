public class OOPs{
  public static void main(String[] args) {
    Pen p1 = new Pen();//created pen obj using constructor
    p1.setColor("blue");
    //System.out.print(p1.color);
    System.out.print(p1.getColor());

    BankAccount myAcc = new BankAccount();
    myAcc.userName= "asad";
    //myAcc.passwords = "ewfwf";
    myAcc.setPassword("abcd");
  }
}

class BankAccount{
    public String userName;
    private String passwords;
    public void setPassword(String pwd){
        passwords = pwd;
    }
}

class Pen{
    private String color;
    int size;

    //getters
    String getColor(){
        return this.color;
    }

    //setters
    void setColor(String newColor){
        this.color = newColor;
    }

    void setSize(int newSize){
        this.size = newSize;
    }
}