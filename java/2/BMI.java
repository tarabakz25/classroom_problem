import java.util.Scanner;
public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double height = sc.nextDouble();
        double weight = sc.nextDouble();

        double bmi = weight / (height * height);
        System.out.println("あなたのBMIは " + bmi + " です。");

        sc.close();
    } 
}
