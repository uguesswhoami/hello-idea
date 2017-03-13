package com.xiaoke.connection;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by  on 17/3/12.
 */
public class Pool {

    private List<Connection> connectionPool = new LinkedList<Connection>();

    public Pool(int initialSize) {
        if (initialSize > 0){
            for (int i=0; i<initialSize; i++){
                connectionPool.add(ConnectionDriver.getConnection());
            }
        }
    }

    public Connection fetchConnection(long timeout) throws TimeoutException {
        synchronized (connectionPool){
            try {
                if (timeout <= 0){
                    while (connectionPool.isEmpty()){
                        connectionPool.wait();
                    }
                    System.out.println(Thread.currentThread().getId() + "get connection");
                    return connectionPool.remove(0);
                } else {
                    long future = System.currentTimeMillis() + timeout;
                    long remaining = timeout;
                    while (connectionPool.isEmpty() && remaining > 0){
                        connectionPool.wait();
                        remaining = future - System.currentTimeMillis();
                    }
                    if (!connectionPool.isEmpty()){
                        System.out.println(Thread.currentThread().getId() + "get connection");
                        return connectionPool.remove(0);
                    } else {
                        throw new TimeoutException("get connection timeout");
                    }
                }
            }catch (InterruptedException e){
                System.out.println("fetchConnection error " + e);
                return null;
            }
        }
    }

    public void realeaseConnection(Connection connection){
        if (connection != null){
            synchronized (connectionPool){
                connectionPool.add(connection);
                connectionPool.notifyAll();
            }
        }

    }
}
