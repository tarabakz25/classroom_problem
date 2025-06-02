interface VendingMachine {
  void buy();
}

public class Vending {
  class Juice implements VendingMachine {
    public void buy() {
      System.out.println("ジュースを購入しました");
    }
  }
  
  class Snack implements VendingMachine {
    public void buy() {
      System.out.println("スナックを購入しました");
    }
  }

  public static void main(String[] args) {
    Vending vending = new Vending();
    VendingMachine j = vending.new Juice();
    j.buy();
    VendingMachine s = vending.new Snack();
    s.buy();
  }
}
