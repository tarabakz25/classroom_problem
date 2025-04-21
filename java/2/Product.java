public class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static void main(String[] args) {
        Product apple = new Product("りんご", 120);

        System.out.println("商品名：" + apple.name);
        System.out.println("価格：" + apple.price);
    }
}
