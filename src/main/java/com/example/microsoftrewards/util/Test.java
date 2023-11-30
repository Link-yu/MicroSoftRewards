package com.example.microsoftrewards.util;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class Test {
    public static void main(String[] args) {
        foreachArr(value -> System.out.println(value));
    }

    public static void foreachArr(IntConsumer consumer) {
        int[] arr = {1, 2, 3, 4,5,6,7,8,9,10};
        for (int i : arr) {
            consumer.accept(i);
        }
    }

    public static <R> R typeConver(Function<String, R> function) {
        String str = "123456";
        R result = function.apply(str);
        return result;
    }

    public static int calculateName(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }

    public static void printName(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4,5,6,7,8,9,10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }
}
