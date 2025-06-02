abstract class Animals {
  String name;
  abstract void speak();
}

interface Flyable {
  void fly();
}

interface Swimmable {
  void swim();
}

class Duck extends Animals implements Flyable, Swimmable {
  public Duck() {
      name = "アヒル";
  }
  public void speak() {
      System.out.println("ガーガー！");
  }
  public void fly() {
      System.out.println("飛べるよ！");
  }
  public void swim() {
      System.out.println("泳げるよ！");
  }
}

public class zoo {
  public static void main(String[] args) {
      Duck d = new Duck();
      d.speak();
      d.fly();
      d.swim();
  }
}