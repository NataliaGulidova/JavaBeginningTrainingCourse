package com.tyshchenko.java.benchmarks;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author Alexander Tyshchenko.
 */
public class PrimeNumbersBenchmark {

    @Benchmark
    @BenchmarkMode(value = Mode.AverageTime)
    public void generatePrimesWithOptimization() {
        StringBuilder primes = new StringBuilder();

        label:  for (int i = 2; i <= 10_000; i++) {
                    for (int j = 2; j < i; j++) {
                        if ((i % j) == 0) {
                            continue label;
                        }
                    }
                    primes.append(i).append(" ");
                }
    }

    @Benchmark
    @BenchmarkMode(value = Mode.AverageTime)
    public void generatePrimesWithoutOptimization() {
        StringBuilder primes = new StringBuilder();
        boolean flag;
        for (int i = 2; i <= 10_000; i++) {
            flag = true;
            for (int j = 2; j < i; j++) {
                flag = flag & (i % j > 0);
            }
            if (flag)
                primes.append(i).append(" ");
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(PrimeNumbersBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
