package com.xiaoke.connection;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;

/**
 * Created by luotong on 17/3/12.
 */
public class BootStrap {

    private static Pool pool = new Pool(20);

    private static final int threadCount = 30;
    private static CountDownLatch countDownLatch;

    public static void main(String[] args) {

        countDownLatch = new CountDownLatch(threadCount);
        for (int i=0; i<threadCount; i++){
            new Thread(new ConnectionRunner()).start();
        }

        try {
            countDownLatch.countDown();
            System.out.println("main thread start run...");
        }catch (Exception e){

        }
    }

    static class ConnectionRunner implements Runnable{
        public void run() {
            Connection connection = null;
            try {
                connection = pool.fetchConnection(100);
                connection.createStatement();
                connection.commit();
            }catch (Exception e){
                System.out.println("execute sql  error " + e);
            }finally {
                pool.realeaseConnection(connection);
                countDownLatch.countDown();
            }
        }
    }
}
