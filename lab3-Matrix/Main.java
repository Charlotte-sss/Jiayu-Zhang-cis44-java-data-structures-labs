public class Main {
    public static void main(String[] args) {
        try {

            Matrix m1 = new Matrix(2, 2);
            Matrix m2 = new Matrix(2, 2);

            m1.populateRandom();
            m2.populateRandom();

            System.out.println("Matrix 1:");
            System.out.println(m1);

            System.out.println("Matrix 2:");
            System.out.println(m2);


            Matrix sum = m1.add(m2);
            System.out.println("Matrix 1 + Matrix 2:");
            System.out.println(sum);


            Matrix product = m1.multiply(m2);
            System.out.println("Matrix 1 * Matrix 2:");
            System.out.println(product);


            Matrix m3 = new Matrix(3, 2);
            m3.populateRandom();
            System.out.println("Matrix 3:");
            System.out.println(m3);


            System.out.println("Trying to add Matrix1 + Matrix3...");
            Matrix invalidSum = m1.add(m3);

        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
