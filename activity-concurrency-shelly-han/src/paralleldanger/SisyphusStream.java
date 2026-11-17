package paralleldanger;

import java.util.stream.LongStream;

public class SisyphusStream {
    public static void main(String[] args) {
        // SumCalculator calc = new SumCalculator();
        // LongStream.range(0, 100L)
        //     .map(n -> 1)
        //     .forEach(calc::add);
        // System.out.println(calc.getTotal());

        Timer.measure(20, () -> {  // Repeat the following test 20 times:
            long total = LongStream.range(0, 10000000000L)  // Process this many numbers
                .parallel()
                .map(n -> 1)
                .sum();
            System.out.println("total=" + total);
        });   
    }
}
