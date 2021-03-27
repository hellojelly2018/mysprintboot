package com.study.boot.base;

/**
 * @author Yangjiali
 * @create 2021-03-21:14 21:14
 */
public class TestException {
    public static String getName(int idx) {
        String[] names = new String[] {"Jelly", "Jack", "Hello"};
        if (idx < 0)
            throw new NegativeIndexException("负数索引。");

        return names[idx];
    }
    public static void main(String[] args) {
        try {
            TestException.getName(-2);
        } catch (NegativeIndexException e) {
            e.printStackTrace();
        }
    }
}
