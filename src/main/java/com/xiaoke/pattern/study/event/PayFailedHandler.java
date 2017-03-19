package com.xiaoke.pattern.study.event;

/**
 * Created by luotong on 17/3/12.
 */
public class PayFailedHandler implements Handler<PayFailedEvent> {

    public void onEvent(PayFailedEvent event) {
        System.out.println("pay success handle" + event);
    }
}
