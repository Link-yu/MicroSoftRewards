package com.example.microsoftrewards.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Double value = 0.00005;
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        System.out.println(bigDecimal.stripTrailingZeros().toPlainString());
    }

    public static void testMap() {
        Map<String, String> maps = new HashMap<>();
        maps.put("1", "1");
        maps.put("3", "2");
        maps.put("9", "3");
        Optional<Integer> reduce = maps.entrySet().stream()
                .map(stringStringEntry -> Integer.valueOf(stringStringEntry.getKey()))
                .reduce((integer, integer2) -> {
                    return integer > integer2 ? integer:integer2;
                });
        System.out.println(reduce.get());
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
    public static void test() {
        Integer[] arr = {1, 2, 3, 4,5,6,7,8,9,10};
        Arrays.stream(arr).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        });
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
