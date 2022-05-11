package com.patternhub.java8Examples.basicStreamsExample;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class BasicStreamExample {
    public static void main(String[] args) {
        BasicStreamExample b= new BasicStreamExample();

        arithmeticOperationOnInteger(b);



    }

    private static void arithmeticOperationOnInteger(BasicStreamExample b) {

        int[] integers = b.getNumbers();

        OptionalInt max = IntStream.of(integers)
                .max();
        if (max.isPresent()){
            System.out.println(max.getAsInt());
        }

//        double sum = IntStream.of(integers)
//                .average().getAsDouble();
//                //.sum(); //max, min, avg
//        System.out.println(sum);
        IntStream stream = IntStream.of(integers);
        System.out.println(IntStream.of(integers)
                .count());
//        stream.distinct().sorted().forEach(System.out::print);

//        stream.limit(3).boxed().forEach(System.out::println);

//        boolean odd = stream.anyMatch(x -> x % 2 == 1);
//        boolean even = stream.allMatch(x -> x % 2 == 0);
//        System.out.println(odd);
//        System.out.println(even);

        IntStream.of(b.getNumbers())
                .sorted().forEach(System.out::println);

        IntStream.of(integers)
                .filter(x -> x % 2 == 0)
                .filter(x -> x > 10)
                .map(x -> x / 2)
                .forEach(System.out::print);
    }

    public int[] getNumbers() {

        return new int[]{1,9,3,4,26,3,45,6,79,34};
    }
}
