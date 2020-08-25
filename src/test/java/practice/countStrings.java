package practice;

public class countStrings {
    public static void main(String[] args) {

//        try {
//            String str = "abcdefgab";
//            char[] chars = str.toCharArray();
//            Map<String, Integer> countWords = new HashMap<>();
//            int count = 0;
//            countWords.put("count", chars.length);
////        for (int i = 0; i < str.length(); i++) {
////            countWords.put("count", ++count);
////        }
//            System.out.println(countWords);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//        }


        int m = 123;
        int n;
        int sum = 0;
        while (m > 0) {
            n = m % 10;
            sum = sum + n;
            m = m / 10;
        }
        System.out.println("Sum of Digits:" + sum);
    }
}
