class Animal {
     void speak() {
        System.out.println("こんにちは");
     }
}

class Cat extends Animal {
    void meow() {
        System.out.println("にゃー");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.speak();
        cat.meow();
    }
}
