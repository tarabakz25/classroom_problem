// 親クラス
class Animal {
  void speak() {
    System.out.println("なにか鳴く");
  }
}

// 子クラス
class Dog extends Animal {
  void speak() {
    System.out.println("ワンワン");
  }
}

class Cat extends Animal {
  void speak() {
    System.out.println("にゃーにゃー");
  }
}

class Bird extends Animal {
  void speak() {
    System.out.println("ぴよぴよ");
  }
}

public class Polymorphism {
  public static void main(String[] args) {
    Animal[] animals = { new Dog(), new Cat(), new Bird() };
    for (Animal animal : animals) {
      animal.speak(); // それぞれの動物の鳴き声が出ればOK！
    }
  }
}