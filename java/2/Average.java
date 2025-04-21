public class Average {
    public static void main(String[] args) {
        int[] scores = {78, 85, 90, 72, 88};
        
        for(int i = 1; i <= scores.length; i++) {
            System.out.println(i + "番目の人の点数は" + scores[i - 1] + "点です。");
        }

        System.out.println("平均点：" + (scores[0] + scores[1] + scores[2] + scores[3] + scores[4]) / scores.length);
    }   
}
