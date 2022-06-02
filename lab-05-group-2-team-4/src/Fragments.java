public class Fragments {
    public long fragment1(long n) {
        long sum = 0;
        for (long i = 0; i < n; i++) {
            sum++;
        }
        return sum;
    }

    public long fragment2(long n){
        long sum = 0;
        for(long i = 0; i< n; i ++){
            for(long j = 0; j < n; j++){
                sum++;
            }
        }
        return sum;
    }

    public long fragment3(long n){
        long sum = 0;
        for(long i = 0; i < n; i++){
            for(long j = i; j < n; j++){
                sum++;
            }
        }
        return sum;
    }

    public long fragment4(long n){
        long sum = 0;
        for(long i = 0; i< n; i++) {
            sum++;
            for (long j = 0; j < n; j++) {
                sum++;
            }
        }
        return sum;
    }

    public long fragment5(long n) {
        long sum = 0;
        for (long j = 0; j < n*n; j++) {
            sum++;
        }
        return sum;
    }

    public long fragment6(long n) {
        long sum = 0;
        for (long i = 0; i < n; i++) {
            for (long j = 0; j < i; j++) {
                sum++;
            }
        }
        return sum;
    }

    public long fragment7(long n) {
        long sum = 0;
        for (long i = 0; i< n; i++) {
            for (long j = 0; j < n*n; j++) {
                if (j % i == 0) {
                    for (long k = 0; k < j; k++) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    public boolean isPrime (double p) {
        if (p < 2) {
            return false;
        }
        for (double i = 2; i * i <= p; i++) {
            if (p % i == 0) {
                return false;
            }
        }
        return true;
    }
}
