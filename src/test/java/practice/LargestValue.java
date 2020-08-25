package practice;

public class LargestValue {
    public static void main(String[] args) {
        int[] a = {28, 3, 15, 9, 17, 4, 23, 2};

        int val = a[0];
        int val1 = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > val) {
                val = a[i];
            } else if (a[i] < val1) {
                val1 = a[i];
            }
        }
        System.out.println("Largest Number - " + val);
        System.out.println("Smallest Number - " + val1);
    }
}

