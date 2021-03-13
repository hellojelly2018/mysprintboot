package com.study.boot.thread;

/**
 * @author Yangjiali
 * @create 2021-03-17:43 17:43
 */
public class LazySingle {
    private static LazySingle single;
    private LazySingle() {}
    public static LazySingle getInstance() {
        if (null == single) {
            synchronized (LazySingle.class) {
                if (null == single) {
                    single = new LazySingle();
                }
            }
        }
        return single;
    }
}
