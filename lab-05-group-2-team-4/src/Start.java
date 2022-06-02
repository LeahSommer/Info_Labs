
public class Start {
    public static void main (String[] args) {
        Fragments f = new Fragments();

        /*for (int n = 1; n < 10000; n++) {
            long time = System.nanoTime();
            f.fragment1(n);
            if (n % 100 == 0) {
                System.out.println(n + ": " + (System.nanoTime() - time) + " ms");
            }
        }*/

        for (double n = Math.pow(2,20)-100; n < Math.pow(2,20); n++) {
            long time = System.nanoTime();
            f.isPrime(n);
            System.out.println(n + ": " + (System.nanoTime() - time) + " ms");
        }

        for (double n = Math.pow(2,40)-100; n < Math.pow(2,40); n++) {
            long time = System.nanoTime();
            f.isPrime(n);
            System.out.println(n + ": " + (System.nanoTime() - time) + " ms");
        }
    }
}
