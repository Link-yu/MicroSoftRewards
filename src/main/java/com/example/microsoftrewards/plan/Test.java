package com.example.microsoftrewards.plan;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;

public class Test {
    public static void main(String[] args) {

    }

    public static String operatorRightConvert(String data) {
        if (StringUtils.isBlank(data)) {
            return "";
        }
        char[] chars = data.toCharArray();
        StringJoiner joiner = new StringJoiner(",");
        for (char c : chars) {
            if (StringUtils.equals(String.valueOf(c), "1")) {
                joiner.add("1");
            }
            if (StringUtils.equals(String.valueOf(c), "2")) {
                joiner.add("2").add("4");
            }
        }
        if (StringUtils.isBlank(joiner.toString())) {
            System.out.println(false);
        }
        return joiner.toString();
    }

    public int pivotIndex(int[] nums) {
        int sumTotal = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == sumTotal) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
