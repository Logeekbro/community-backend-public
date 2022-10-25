package com.db.community.utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    private static final int[] asciiArr = new int[94];

    static {
        for (int i = 0; i < 94; i++) {
            asciiArr[i] = 33 + i;
        }
    }


    /**
     * 生成一个包含某些可见字符ASCII码的队列
     * @param size 生成的字符数量
     * @return 生成的队列
     */
    public static Queue<Integer> getDistinctRandomAsciiIntQueue(int size) {
        int maxIndex = 93;
        int[] copiedAsciiArr = Arrays.copyOf(asciiArr, asciiArr.length);
        Queue<Integer> queue = new LinkedList<>();
        while (queue.size() < size) {
            int r = (int)(Math.random() * (maxIndex + 1));
            queue.add(copiedAsciiArr[r]);
            copiedAsciiArr[r] = copiedAsciiArr[maxIndex--];
        }
        return queue;
    }
}
