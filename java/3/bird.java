class Bird {
    String name;
    String species;
    String sound;

    Bird(String name, String species, String sound) {
        this.name = name;
        this.species = species;
        this.sound = sound;
    }

    void sing() {
        System.out.println(name + "(" + species + ")" + " が" + sound + "と鳴いています");
    }

    public static void main(String[] args) {
        Bird piyo = new Bird("ピヨ", "スズメ", "ちゅんちゅん");
        piyo.sing();
    } 
}