import java.util.Random;
import java.util.Arrays;

class DotProduct{
    public static void main(String[] args) {
        int n = 5;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        Random rand = new Random();


        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(10);
            b[i] = rand.nextInt(10);
            c[i] = a[i] * b[i];
        }


        System.out.println("Array a: " + Arrays.toString(a));
        System.out.println("Array b: " + Arrays.toString(b));
        System.out.println("Array c (a[i] * b[i]): " + Arrays.toString(c));
    }
}
