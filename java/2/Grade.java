public class Grade {
    public static String judge(int score) {
        if(score >= 90) return "とてもよくできました";
        else if(score >= 70) return "よくできました";
        else if(score >= 50) return "まずまずです";
        else return "がんばりましょう";
    }
    
    public static void main(String[] args) {
        String result = judge(85);
        System.out.println(result);
    }
}
